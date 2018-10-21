package com.github.footballclubsubmission.ui.activities.matchDetail.presenter

import com.github.footballclubsubmission.ui.activities.matchDetail.interactor.MatchDetailMvpInteractor
import com.github.footballclubsubmission.ui.activities.matchDetail.view.MatchDetailMvpView
import com.github.footballclubsubmission.ui.base.presenter.BasePresenter
import com.github.footballclubsubmission.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/21/2018
 *  check https://github.com/KeiLazu for more
 */
class MatchDetailPresenter<V: MatchDetailMvpView, I: MatchDetailMvpInteractor>
        @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor, schedulerProvider, compositeDisposable), MatchDetailMvpPresenter<V,I>  {

    override fun onViewCreated(eventId: Int) {
        getEventDetail(eventId)
    }

    private fun getEventDetail(eventId: Int) {
        getView()?.showProgress()
        interactor?.let { it ->
            it.getEventDetailApi(eventId)
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe { EventLeagueResponse ->
                    getView()?.let {
                        it.hideProgress()
                        it.displayEventDetail(EventLeagueResponse.events[0])
                    }
                }
        }
    }

    override fun getTeamBadge(teamId: Int, isHomeBadge: Boolean) {
        interactor?.let { it ->
            it.getTeamBadgeApi(teamId)
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe{ response ->
                    getView()?.let {
                        if (isHomeBadge) it.displayHomeBadge(response.teams[0], true)
                        else it.displayHomeBadge(response.teams[0], false)
                    }
                }
        }
    }
}