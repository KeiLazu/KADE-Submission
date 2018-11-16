package com.github.footballclubsubmission.ui.fragments.teamplayer.presenter

import com.github.footballclubsubmission.ui.base.presenter.BasePresenter
import com.github.footballclubsubmission.ui.fragments.teamplayer.interactor.TeamPlayerMvpInteractor
import com.github.footballclubsubmission.ui.fragments.teamplayer.view.TeamPlayerMvpView
import com.github.footballclubsubmission.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/12/2018
 *  check https://github.com/KeiLazu for more
 */
class TeamPlayerPresenter<V : TeamPlayerMvpView, I : TeamPlayerMvpInteractor>
@Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable)
    : BasePresenter<V,I>(interactor, schedulerProvider, compositeDisposable), TeamPlayerMvpPresenter<V,I> {

    override fun getPlayerListData(teamId: Int) {
        getView()?.showProgress()
        interactor?.let { it ->
            it.getPlayerListData(teamId)
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({ playerListResponse ->
                    getView()?.let { v ->
                        v.hideProgress()
                        v.putPlayerListData(playerListResponse)
                    }
                },{throwable ->
                    getView()?.let {
                        it.hideProgress()
                        throwable.printStackTrace()
                    }
                })
        }
    }

}