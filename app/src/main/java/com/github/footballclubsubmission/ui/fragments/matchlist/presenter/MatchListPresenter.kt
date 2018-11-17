package com.github.footballclubsubmission.ui.fragments.matchlist.presenter

import android.util.Log
import com.github.footballclubsubmission.data.db.favoritematch.FavoriteMatchModel
import com.github.footballclubsubmission.data.db.favoritematch.FavoriteMatchRepository
import com.github.footballclubsubmission.data.db.favoritematch.FavoriteTeamModel
import com.github.footballclubsubmission.data.db.favoritematch.FavoriteTeamRepository
import com.github.footballclubsubmission.ui.base.presenter.BasePresenter
import com.github.footballclubsubmission.ui.fragments.matchlist.interactor.MatchListMvpInteractor
import com.github.footballclubsubmission.ui.fragments.matchlist.view.MatchListFragment
import com.github.footballclubsubmission.ui.fragments.matchlist.view.MatchListMvpView
import com.github.footballclubsubmission.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
class MatchListPresenter<V : MatchListMvpView, I : MatchListMvpInteractor>
@Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BasePresenter<V, I>(interactor, schedulerProvider, compositeDisposable), MatchListMvpPresenter<V, I> {

    override fun onViewPrepared(
        displayMode: Int,
        matchDb: FavoriteMatchRepository?
    ) {
        getView()?.showProgress()
        when (displayMode) {
            MatchListFragment.DISPLAY_MODE_LAST_MATCH -> getLastMatchApi()
            MatchListFragment.DISPLAY_MODE_NEXT_MATCH -> getNextMatchApi()
            MatchListFragment.DISPLAY_MODE_FAV_MATCH -> getFavData(matchDb)
        }
    }

    fun getLastMatchApi() {
        interactor?.let { it ->
            it.getLastMatchApi()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe ({ EventLeagueResponse ->
                    getView()?.let {
                        it.hideProgress()
                        it.putLastMatchData(EventLeagueResponse)
                    }
                }, { throwable ->
                    Log.i(MatchListPresenter::class.java.simpleName, "ERROR:\n$throwable")
                })
        }
    }

    fun getNextMatchApi() {
        interactor?.let { it ->
            it.getNextMatchApi()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe ({ EventLeagueResponse ->
                    getView()?.let {
                        it.hideProgress()
                        it.putNextMatchData(EventLeagueResponse)
                    }
                },{ throwable ->
                    Log.i(MatchListPresenter::class.java.simpleName, "ERROR:\n$throwable")
                })
        }
    }

    fun getFavData(matchDb: FavoriteMatchRepository?) {
        matchDb?.use {
            val result = select(FavoriteMatchModel.TABLE_FAVORITE).parseList(classParser<FavoriteMatchModel>())
            getView()?.let {
                it.hideProgress()
                it.putFavData(result)
            }
        }
    }

    override fun getFavTeamData(teamDb: FavoriteTeamRepository?) {
        teamDb?.use {
            val result : List<FavoriteTeamModel> = select(FavoriteTeamModel.TABLE_FAV_TEAM).parseList(classParser())
            getView()?.let {
                it.hideProgress()
                it.putFavTeamData(result)
            }
        }
    }

}