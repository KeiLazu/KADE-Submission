package com.github.footballclubsubmission.ui.activities.matchDetail.presenter

import com.github.footballclubsubmission.ui.activities.matchDetail.interactor.MatchDetailMvpInteractor
import com.github.footballclubsubmission.ui.activities.matchDetail.view.MatchDetailMvpView
import com.github.footballclubsubmission.ui.base.presenter.MvpPresenter

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/21/2018
 *  check https://github.com/KeiLazu for more
 */
interface MatchDetailMvpPresenter<V : MatchDetailMvpView, I : MatchDetailMvpInteractor> : MvpPresenter<V, I> {
    fun onViewCreated(eventId: Int)
    fun getTeamBadge(teamId: Int, isHomeBadge: Boolean)
}