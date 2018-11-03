package com.github.footballclubsubmission.ui.activities.matchdetail.presenter

import com.github.footballclubsubmission.data.db.favoritematch.FavoriteMatchRepository
import com.github.footballclubsubmission.data.models.EventsItem
import com.github.footballclubsubmission.ui.activities.matchdetail.interactor.MatchDetailMvpInteractor
import com.github.footballclubsubmission.ui.activities.matchdetail.view.MatchDetailMvpView
import com.github.footballclubsubmission.ui.base.presenter.MvpPresenter

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/21/2018
 *  check https://github.com/KeiLazu for more
 */
interface MatchDetailMvpPresenter<V : MatchDetailMvpView, I : MatchDetailMvpInteractor> : MvpPresenter<V, I> {
    fun getEventDetail(eventId: Int)
    fun getTeamBadge(teamId: Int, isHomeBadge: Boolean)
    fun addToFav(
        matchDb: FavoriteMatchRepository,
        eventItem: EventsItem,
        homeBadge: String?,
        awayBadge: String?
    )
}