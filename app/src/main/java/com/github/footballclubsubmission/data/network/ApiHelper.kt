package com.github.footballclubsubmission.data.network

import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.data.models.PlayerListResponse
import com.github.footballclubsubmission.data.models.TeamResponse
import io.reactivex.Observable

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
interface ApiHelper {

    fun getLastMatchApi(): Observable<EventLeagueResponse>
    fun getNextMatchApi(): Observable<EventLeagueResponse>
    fun getEventDetailApi(eventId: Int): Observable<EventLeagueResponse>
    fun getTeamBadgeApi(teamId: Int): Observable<TeamResponse>
    fun getTeamLeagueApi(leagueName: String): Observable<TeamResponse>
    fun getPlayerListTeamApi(teamId: Int): Observable<PlayerListResponse>
}