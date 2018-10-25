package com.github.footballclubsubmission.ui.fragments.matchList.interactor

import com.github.footballclubsubmission.data.network.ApiHelper
import com.github.footballclubsubmission.ui.base.interactor.BaseInteractor
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
class MatchListInteractor @Inject internal constructor(apiHelper: ApiHelper) : BaseInteractor(apiHelper),
    MatchListMvpInteractor {

    override fun getLastMatchApi() = apiHelper.getLastMatchApi()


    override fun getNextMatchApi() = apiHelper.getNextMatchApi()
}