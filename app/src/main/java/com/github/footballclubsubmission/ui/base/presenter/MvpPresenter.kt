package com.github.footballclubsubmission.ui.base.presenter

import com.github.footballclubsubmission.ui.base.interactor.MvpInteractor
import com.github.footballclubsubmission.ui.base.view.MvpView

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
interface MvpPresenter<V: MvpView, I: MvpInteractor> {
    fun onAttach(view: V?)
    fun onDetach()
    fun getView(): V?
}