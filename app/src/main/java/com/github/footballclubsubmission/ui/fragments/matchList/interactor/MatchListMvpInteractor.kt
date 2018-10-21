package com.github.footballclubsubmission.ui.fragments.matchList.interactor

import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.ui.base.interactor.MvpInteractor
import io.reactivex.Observable

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
interface MatchListMvpInteractor : MvpInteractor {

    fun getLastMatchApi(): Observable<EventLeagueResponse>
    fun getNextMatchApi(): Observable<EventLeagueResponse>
}