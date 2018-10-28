package com.github.footballclubsubmission.ui.base.view

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
interface MvpView {
    fun showProgress()
    fun hideProgress()
    fun showMessage(message: String)
}