package com.github.footballclubsubmission.activities.main

import com.github.footballclubsubmission.data.models.Team

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/18/2018
 *  check https://github.com/KeiLazu for more
 */
interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}