package com.github.footballclubsubmission.activities.main

import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.data.network.ApiRepository
import com.github.footballclubsubmission.data.network.TheSportDbApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/18/2018
 *  check https://github.com/KeiLazu for more
 */
class MainPresenter(
    private val view: MainView,
    private val apiRepository: ApiRepository,
    private val gson: Gson) {

    fun getTeamList(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(
                TheSportDbApi.getTeams(league)),
                TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }

}