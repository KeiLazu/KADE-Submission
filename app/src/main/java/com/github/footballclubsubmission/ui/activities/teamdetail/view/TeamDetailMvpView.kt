package com.github.footballclubsubmission.ui.activities.teamdetail.view

import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.ui.base.view.MvpView

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/11/2018
 *  check https://github.com/KeiLazu for more
 */
interface TeamDetailMvpView : MvpView {
    fun displayTeamData(teamResponse: TeamResponse)
    fun showMessageAddDb()
    fun showMessageRemoveDb()
    fun showMessageError()
}