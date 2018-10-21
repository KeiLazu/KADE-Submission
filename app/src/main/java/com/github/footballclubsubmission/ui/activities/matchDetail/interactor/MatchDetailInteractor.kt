package com.github.footballclubsubmission.ui.activities.matchDetail.interactor

import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.data.network.ApiHelper
import com.github.footballclubsubmission.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/21/2018
 *  check https://github.com/KeiLazu for more
 */
class MatchDetailInteractor @Inject internal constructor(apiHelper: ApiHelper) : BaseInteractor(apiHelper), MatchDetailMvpInteractor {

    override fun getEventDetailApi(eventId: Int) = apiHelper.getEventDetailApi(eventId)

    override fun getTeamBadgeApi(teamId: Int): Observable<TeamResponse> = apiHelper.getTeamBadgeApi(teamId)
}