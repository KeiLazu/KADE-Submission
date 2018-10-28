package com.github.footballclubsubmission.ui.fragments.matchlist.presenter

import com.github.footballclubsubmission.data.db.favoritematch.FavoriteMatchRepository
import com.github.footballclubsubmission.ui.base.presenter.MvpPresenter
import com.github.footballclubsubmission.ui.fragments.matchlist.interactor.MatchListMvpInteractor
import com.github.footballclubsubmission.ui.fragments.matchlist.view.MatchListMvpView

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
interface MatchListMvpPresenter<V : MatchListMvpView, I : MatchListMvpInteractor> : MvpPresenter<V, I> {

    fun onViewPrepared(
        displayMode: Int,
        matchDb: FavoriteMatchRepository?
    )
}