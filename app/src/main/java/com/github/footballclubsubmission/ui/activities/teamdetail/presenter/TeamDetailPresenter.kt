package com.github.footballclubsubmission.ui.activities.teamdetail.presenter

import android.util.Log
import com.github.footballclubsubmission.ui.activities.teamdetail.interactor.TeamDetailMvpInteractor
import com.github.footballclubsubmission.ui.activities.teamdetail.view.TeamDetailMvpView
import com.github.footballclubsubmission.ui.base.presenter.BasePresenter
import com.github.footballclubsubmission.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/11/2018
 *  check https://github.com/KeiLazu for more
 */
class TeamDetailPresenter<V: TeamDetailMvpView, I: TeamDetailMvpInteractor>
    @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable)
    : BasePresenter<V,I>(interactor, schedulerProvider, compositeDisposable), TeamDetailMvpPresenter<V,I> {

    override fun getTeamDetailData(teamId: Int) {
        getView()?.showProgress()
        interactor?.let { its ->
            its.getTeamDetailData(teamId)
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({teamResponse ->
                    getView()?.let {
                        it.hideProgress()
                        it.displayTeamData(teamResponse)
                    }
                },{throwable ->
                    Log.e(TeamDetailPresenter::class.java.simpleName, "error>\n$throwable")
                })
        }
    }

}