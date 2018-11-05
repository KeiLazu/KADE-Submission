package com.github.footballclubsubmission.ui.activities.matchdetail.view

import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.data.models.EventsItem
import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.data.models.TeamsItem
import com.github.footballclubsubmission.ui.base.view.MvpView

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/21/2018
 *  check https://github.com/KeiLazu for more
 */
interface MatchDetailMvpView : MvpView {

    fun displayEventDetail(eventLeagueResponse: EventLeagueResponse)
    fun showMessageAddDb()
    fun showMessageRemoveDb()
    fun showMessageError()
    fun displayHomeBadge(teamsItem: TeamResponse, isHomeBadge: Boolean)
}