package com.github.footballclubsubmission.ui.fragments.teams.interactor

import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.data.network.ApiHelper
import com.github.footballclubsubmission.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/9/2018
 *  check https://github.com/KeiLazu for more
 */
class TeamsInteractor @Inject internal constructor(apiHelper: ApiHelper) : BaseInteractor(apiHelper), TeamsMvpInteractor {

    override fun getTeamsData(leagueName: String): Observable<TeamResponse> = apiHelper.getTeamLeagueApi(leagueName)
}