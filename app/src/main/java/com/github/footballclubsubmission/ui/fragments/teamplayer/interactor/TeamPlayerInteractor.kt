package com.github.footballclubsubmission.ui.fragments.teamplayer.interactor

import com.github.footballclubsubmission.data.models.PlayerListResponse
import com.github.footballclubsubmission.data.network.ApiHelper
import com.github.footballclubsubmission.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/12/2018
 *  check https://github.com/KeiLazu for more
 */
class TeamPlayerInteractor @Inject internal constructor(apiHelper: ApiHelper) : BaseInteractor(apiHelper), TeamPlayerMvpInteractor {

    override fun getPlayerListData(teamId: Int): Observable<PlayerListResponse> = apiHelper.getPlayerListTeamApi(teamId)

}