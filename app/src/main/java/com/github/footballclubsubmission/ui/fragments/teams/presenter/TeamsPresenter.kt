package com.github.footballclubsubmission.ui.fragments.teams.presenter

import android.util.Log
import com.github.footballclubsubmission.ui.base.presenter.BasePresenter
import com.github.footballclubsubmission.ui.fragments.teams.interactor.TeamsMvpInteractor
import com.github.footballclubsubmission.ui.fragments.teams.view.TeamsMvpView
import com.github.footballclubsubmission.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/9/2018
 *  check https://github.com/KeiLazu for more
 */
class TeamsPresenter<V : TeamsMvpView, I : TeamsMvpInteractor> @Inject internal constructor
    (interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) :
    BasePresenter<V, I>(interactor, schedulerProvider, compositeDisposable), TeamsMvpPresenter<V, I> {

    override fun getTeamLeaguesData(leagueName: String) {
        getView()?.showProgress()
        interactor?.let { it ->
            it.getTeamsData(leagueName)
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({ teamResponse ->
                    getView()?.let { view ->
                        view.hideProgress()
                        view.putTeamsData(teamResponse)
                    }
                }, {throwable ->
                    Log.i(TeamsPresenter::class.java.simpleName, "error>\n$throwable")
                })
        }
    }
}