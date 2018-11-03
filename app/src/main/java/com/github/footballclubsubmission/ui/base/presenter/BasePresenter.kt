package com.github.footballclubsubmission.ui.base.presenter

import com.github.footballclubsubmission.ui.base.interactor.MvpInteractor
import com.github.footballclubsubmission.ui.base.view.MvpView
import com.github.footballclubsubmission.utils.AppSchedulerProvider
import com.github.footballclubsubmission.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
abstract class BasePresenter<V: MvpView, I: MvpInteractor> internal constructor(
    protected var interactor: I?,
    protected val schedulerProvider: SchedulerProvider,
    protected val compositeDisposable: CompositeDisposable) : MvpPresenter<V,I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

    override fun getView(): V? = view
}