package com.github.footballclubsubmission.ui.fragments.teamplayer.interactor

import com.github.footballclubsubmission.data.models.PlayerListResponse
import com.github.footballclubsubmission.ui.base.interactor.MvpInteractor
import io.reactivex.Observable

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/12/2018
 *  check https://github.com/KeiLazu for more
 */
interface TeamPlayerMvpInteractor : MvpInteractor {
    fun getPlayerListData(teamId: Int): Observable<PlayerListResponse>
}