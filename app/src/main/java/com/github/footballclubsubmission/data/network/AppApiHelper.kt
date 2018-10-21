package com.github.footballclubsubmission.data.network

import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.data.models.TeamResponse
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
class AppApiHelper @Inject constructor() : ApiHelper {

    override fun getLastMatchApi(): Observable<EventLeagueResponse> =
        Rx2AndroidNetworking.get(ApiEndPoints.getLastMatchUrl())
            .build()
            .getObjectObservable(EventLeagueResponse::class.java)

    override fun getNextMatchApi(): Observable<EventLeagueResponse> =
        Rx2AndroidNetworking.get(ApiEndPoints.getNextMatchUrl())
            .build()
            .getObjectObservable(EventLeagueResponse::class.java)

    override fun getEventDetailApi(eventId: Int): Observable<EventLeagueResponse> =
        Rx2AndroidNetworking.get(ApiEndPoints.getEventDetailUrl(eventId))
            .build()
            .getObjectObservable(EventLeagueResponse::class.java)

    override fun getTeamBadgeApi(teamId: Int): Observable<TeamResponse> =
        Rx2AndroidNetworking.get(ApiEndPoints.getTeamBadgeUrl(teamId))
            .build()
            .getObjectObservable(TeamResponse::class.java)
}