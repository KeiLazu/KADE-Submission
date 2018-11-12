package com.github.footballclubsubmission.ui.fragments.teamdescription.presenter

import com.github.footballclubsubmission.ui.base.presenter.BasePresenter
import com.github.footballclubsubmission.ui.base.presenter.MvpPresenter
import com.github.footballclubsubmission.ui.fragments.teamdescription.interactor.TeamDescriptionMvpInteractor
import com.github.footballclubsubmission.ui.fragments.teamdescription.view.TeamDescriptionMvpView
import com.github.footballclubsubmission.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/12/2018
 *  check https://github.com/KeiLazu for more
 */
class TeamDescriptionPresenter<V: TeamDescriptionMvpView, I: TeamDescriptionMvpInteractor>
    @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable)
    : BasePresenter<V,I>(interactor, schedulerProvider, compositeDisposable), TeamDescriptionMvpPresenter<V,I> {

}