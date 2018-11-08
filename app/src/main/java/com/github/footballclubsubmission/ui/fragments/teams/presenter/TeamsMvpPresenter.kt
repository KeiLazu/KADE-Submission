package com.github.footballclubsubmission.ui.fragments.teams.presenter

import com.github.footballclubsubmission.ui.base.presenter.MvpPresenter
import com.github.footballclubsubmission.ui.fragments.teams.interactor.TeamsMvpInteractor
import com.github.footballclubsubmission.ui.fragments.teams.view.TeamsMvpView

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/9/2018
 *  check https://github.com/KeiLazu for more
 */
interface TeamsMvpPresenter<V: TeamsMvpView, I: TeamsMvpInteractor> : MvpPresenter<V,I> {
}