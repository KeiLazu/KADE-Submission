package com.github.footballclubsubmission.ui.fragments.teamplayer.view

import com.github.footballclubsubmission.data.models.PlayerListResponse
import com.github.footballclubsubmission.ui.base.view.MvpView

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/12/2018
 *  check https://github.com/KeiLazu for more
 */
interface TeamPlayerMvpView : MvpView {
    fun putPlayerListData(playerListResponse: PlayerListResponse)
}