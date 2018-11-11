package com.github.footballclubsubmission.ui.fragments.teams.view

import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.ui.base.view.MvpView

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/9/2018
 *  check https://github.com/KeiLazu for more
 */
interface TeamsMvpView : MvpView {

    fun putTeamsData(teamResponse: TeamResponse)

}