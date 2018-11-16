package com.github.footballclubsubmission.ui.activities.teamdetail.interactor

import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.data.network.ApiHelper
import com.github.footballclubsubmission.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/11/2018
 *  check https://github.com/KeiLazu for more
 */
class TeamDetailInteractor @Inject internal constructor(apiHelper: ApiHelper) : BaseInteractor(apiHelper), TeamDetailMvpInteractor {

    override fun getTeamDetailData(teamId: Int): Observable<TeamResponse> = apiHelper.getTeamBadgeApi(teamId)

}