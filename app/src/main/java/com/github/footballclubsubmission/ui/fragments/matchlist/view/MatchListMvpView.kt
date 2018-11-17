package com.github.footballclubsubmission.ui.fragments.matchlist.view

import com.github.footballclubsubmission.data.db.favoritematch.FavoriteMatchModel
import com.github.footballclubsubmission.data.db.favoritematch.FavoriteTeamModel
import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.ui.base.view.MvpView

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
interface MatchListMvpView : MvpView {

    fun putLastMatchData(eventLeagueResponse: EventLeagueResponse)
    fun putNextMatchData(eventLeagueResponse: EventLeagueResponse)
    fun putFavData(result: List<FavoriteMatchModel>)
    fun putFavTeamData(result: List<FavoriteTeamModel>)
}