package com.github.footballclubsubmission.ui.activities.teamdetail.presenter

import com.github.footballclubsubmission.data.db.favoritematch.FavoriteTeamRepository
import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.data.models.TeamsItem
import com.github.footballclubsubmission.ui.activities.teamdetail.interactor.TeamDetailMvpInteractor
import com.github.footballclubsubmission.ui.activities.teamdetail.view.TeamDetailMvpView
import com.github.footballclubsubmission.ui.base.presenter.MvpPresenter

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/11/2018
 *  check https://github.com/KeiLazu for more
 */
interface TeamDetailMvpPresenter<V: TeamDetailMvpView, I: TeamDetailMvpInteractor> : MvpPresenter<V,I> {
    fun getTeamDetailData(teamId: Int)
    fun addToFav(teamDb: FavoriteTeamRepository, teamsItem: TeamsItem)
}