package com.github.footballclubsubmission.ui.activities.teamdetail.interactor

import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.ui.base.interactor.MvpInteractor
import io.reactivex.Observable

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/11/2018
 *  check https://github.com/KeiLazu for more
 */
interface TeamDetailMvpInteractor : MvpInteractor {
    fun getTeamDetailData(teamId: Int): Observable<TeamResponse>
}