package com.github.footballclubsubmission.ui.activities.matchdetail.interactor

import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.ui.base.interactor.MvpInteractor
import io.reactivex.Observable

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/21/2018
 *  check https://github.com/KeiLazu for more
 */
interface MatchDetailMvpInteractor : MvpInteractor {
    fun getEventDetailApi(eventId: Int): Observable<EventLeagueResponse>
    fun getTeamBadgeApi(teamId: Int): Observable<TeamResponse>
}