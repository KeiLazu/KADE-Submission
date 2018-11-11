package com.github.footballclubsubmission.ui.fragments.teams.interactor

import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.ui.base.interactor.MvpInteractor
import io.reactivex.Observable

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/9/2018
 *  check https://github.com/KeiLazu for more
 */
interface TeamsMvpInteractor : MvpInteractor {

    fun getTeamsData(leagueName: String): Observable<TeamResponse>

}