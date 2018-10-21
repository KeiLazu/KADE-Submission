package com.github.footballclubsubmission.ui.fragments.matchList.presenter

import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.ui.base.presenter.MvpPresenter
import com.github.footballclubsubmission.ui.fragments.matchList.interactor.MatchListMvpInteractor
import com.github.footballclubsubmission.ui.fragments.matchList.view.MatchListMvpView
import io.reactivex.Observable

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
interface MatchListMvpPresenter<V: MatchListMvpView, I: MatchListMvpInteractor> : MvpPresenter<V, I> {

    fun onViewPrepared(displayMode: Int)
}