package com.github.footballclubsubmission.ui.activities.matchdetail.presenter

import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import com.github.footballclubsubmission.data.db.favoritematch.FavoriteMatchModel
import com.github.footballclubsubmission.data.db.favoritematch.FavoriteMatchRepository
import com.github.footballclubsubmission.data.models.EventsItem
import com.github.footballclubsubmission.ui.activities.matchdetail.interactor.MatchDetailMvpInteractor
import com.github.footballclubsubmission.ui.activities.matchdetail.view.MatchDetailMvpView
import com.github.footballclubsubmission.ui.base.presenter.BasePresenter
import com.github.footballclubsubmission.utils.AppSchedulerProvider
import com.github.footballclubsubmission.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.db.insert
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/21/2018
 *  check https://github.com/KeiLazu for more
 */
class MatchDetailPresenter<V : MatchDetailMvpView, I : MatchDetailMvpInteractor>
@Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BasePresenter<V, I>(interactor, schedulerProvider, compositeDisposable), MatchDetailMvpPresenter<V, I> {

    override fun getEventDetail(eventId: Int) {
        getView()?.showProgress()
        interactor?.let { it ->
            it.getEventDetailApi(eventId)
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe ({ EventLeagueResponse ->
                    getView()?.let {
                        it.hideProgress()
                        it.displayEventDetail(EventLeagueResponse)
                    }
                }, { throwable ->
//                    Log.i(MatchDetailPresenter::class.java.simpleName, "ERROR:\n$throwable")
                })
        }
    }

    override fun getTeamBadge(teamId: Int, isHomeBadge: Boolean) {
        interactor?.let { it ->
            it.getTeamBadgeApi(teamId)
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe { response ->
                    getView()?.let {
                        if (isHomeBadge) it.displayHomeBadge(response.teams[0], true)
                        else it.displayHomeBadge(response.teams[0], false)
                    }
                }
        }
    }

    override fun addToFav(
        matchDb: FavoriteMatchRepository,
        eventItem: EventsItem,
        homeBadge: String?,
        awayBadge: String?
    ) {
        try {
            matchDb.use {
                insert(
                    FavoriteMatchModel.TABLE_FAVORITE,
                    FavoriteMatchModel.ID_EVENT to eventItem.idEvent,
                    FavoriteMatchModel.DATE_EVENT to eventItem.dateEvent.toString(),
                    FavoriteMatchModel.HOME_TEAM_ID to eventItem.idHomeTeam?.toInt(),
                    FavoriteMatchModel.AWAY_TEAM_ID to eventItem.idAwayTeam?.toInt(),
                    FavoriteMatchModel.HOME_TEAM to eventItem.strHomeTeam.toString(),
                    FavoriteMatchModel.AWAY_TEAM to eventItem.strAwayTeam.toString(),
                    FavoriteMatchModel.HOME_SCORE to (eventItem.intHomeScore?.toInt() ?: "0"),
                    FavoriteMatchModel.AWAY_SCORE to (eventItem.intAwayScore?.toInt() ?: "0"),
                    FavoriteMatchModel.HOME_GOAL_DETAIL to eventItem.strHomeGoalDetails?.replace("'", "").toString(),
                    FavoriteMatchModel.AWAY_GOAL_DETAIL to eventItem.strAwayGoalDetails?.replace("'", "").toString(),
                    FavoriteMatchModel.HOME_SHOTS to (eventItem.intHomeShots?.toInt() ?: 0),
                    FavoriteMatchModel.AWAY_SHOTS to (eventItem.intAwayShots?.toInt() ?: 0),
                    FavoriteMatchModel.HOME_LINEUP_GOALKEEPER to eventItem.strHomeLineupGoalkeeper.toString(),
                    FavoriteMatchModel.AWAY_LINEUP_GOALKEEPER to eventItem.strAwayLineupGoalkeeper.toString(),
                    FavoriteMatchModel.HOME_LINEUP_DEFENSE to eventItem.strHomeLineupDefense.toString(),
                    FavoriteMatchModel.AWAY_LINEUP_DEFENSE to eventItem.strAwayLineupDefense.toString(),
                    FavoriteMatchModel.HOME_LINEUP_MIDFIELD to eventItem.strHomeLineupMidfield.toString(),
                    FavoriteMatchModel.AWAY_LINEUP_MIDFIELD to eventItem.strAwayLineupMidfield.toString(),
                    FavoriteMatchModel.HOME_LINEUP_FORWARD to eventItem.strHomeLineupForward.toString(),
                    FavoriteMatchModel.AWAY_LINEUP_FORWARD to eventItem.strAwayLineupForward.toString(),
                    FavoriteMatchModel.HOME_LINEUP_SUBS to eventItem.strHomeLineupSubstitutes.toString(),
                    FavoriteMatchModel.AWAY_LINEUP_SUBS to eventItem.strAwayLineupSubstitutes.toString(),
                    FavoriteMatchModel.HOME_BADGE to homeBadge.toString(),
                    FavoriteMatchModel.AWAY_BADGE to awayBadge.toString()
                )
            }
            getView()?.showMessageAddDb()
            Log.i(MatchDetailPresenter::class.java.simpleName, "added to db")
        } catch (e: SQLiteConstraintException) {
            getView()?.showMessageError()
            Log.e(MatchDetailPresenter::class.java.simpleName, "error:\n$e")
        }
    }
}