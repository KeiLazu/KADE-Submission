package com.github.footballclubsubmission.ui.fragments.matchList.view

import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.ui.base.view.MvpView

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
interface MatchListMvpView : MvpView {

    fun putDataMatchList(eventLeagueResponse: EventLeagueResponse)

}