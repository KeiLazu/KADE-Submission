package com.github.footballclubsubmission.ui.fragments.teamdescription.interactor

import com.github.footballclubsubmission.data.network.ApiHelper
import com.github.footballclubsubmission.ui.base.interactor.BaseInteractor
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/12/2018
 *  check https://github.com/KeiLazu for more
 */
class TeamDescriptionInteractor @Inject internal constructor(apiHelper: ApiHelper) : BaseInteractor(apiHelper), TeamDescriptionMvpInteractor {
}