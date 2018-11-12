package com.github.footballclubsubmission.ui.fragments.teamplayer.presenter

import com.github.footballclubsubmission.ui.base.presenter.MvpPresenter
import com.github.footballclubsubmission.ui.fragments.teamplayer.interactor.TeamPlayerMvpInteractor
import com.github.footballclubsubmission.ui.fragments.teamplayer.view.TeamPlayerMvpView

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/12/2018
 *  check https://github.com/KeiLazu for more
 */
interface TeamPlayerMvpPresenter<V : TeamPlayerMvpView, I : TeamPlayerMvpInteractor> : MvpPresenter<V, I> {

}