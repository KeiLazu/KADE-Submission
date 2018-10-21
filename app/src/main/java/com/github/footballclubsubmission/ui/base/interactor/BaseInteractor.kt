package com.github.footballclubsubmission.ui.base.interactor

import com.github.footballclubsubmission.data.network.ApiHelper

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
open class BaseInteractor() : MvpInteractor {

    protected lateinit var apiHelper: ApiHelper

    constructor(apiHelper: ApiHelper) : this() {
        this.apiHelper = apiHelper
    }

}