package com.github.footballclubsubmission.ui.fragments.teamdescription.presenter

import com.github.footballclubsubmission.ui.base.presenter.MvpPresenter
import com.github.footballclubsubmission.ui.fragments.teamdescription.interactor.TeamDescriptionMvpInteractor
import com.github.footballclubsubmission.ui.fragments.teamdescription.view.TeamDescriptionMvpView

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/12/2018
 *  check https://github.com/KeiLazu for more
 */
interface TeamDescriptionMvpPresenter<V: TeamDescriptionMvpView, I: TeamDescriptionMvpInteractor> : MvpPresenter<V,I> {
}