package com.github.footballclubsubmission.ui.activities.teamdetail.presenter

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
}