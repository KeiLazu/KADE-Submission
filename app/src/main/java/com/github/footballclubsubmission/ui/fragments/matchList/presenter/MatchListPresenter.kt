package com.github.footballclubsubmission.ui.fragments.matchList.presenter

import android.util.Log
import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.ui.base.presenter.BasePresenter
import com.github.footballclubsubmission.ui.fragments.matchList.interactor.MatchListMvpInteractor
import com.github.footballclubsubmission.ui.fragments.matchList.view.MatchListFragment
import com.github.footballclubsubmission.ui.fragments.matchList.view.MatchListMvpView
import com.github.footballclubsubmission.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
class MatchListPresenter<V : MatchListMvpView, I : MatchListMvpInteractor>
@Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BasePresenter<V, I>(interactor, schedulerProvider, compositeDisposable), MatchListMvpPresenter<V, I> {

    override fun onViewPrepared(displayMode: Int) {
        getView()?.showProgress()
        when (displayMode) {
            MatchListFragment.DISPLAY_MODE_LAST_MATCH -> getLastMatchApi()
            MatchListFragment.DISPLAY_MODE_NEXT_MATCH -> getNextMatchApi()
        }
    }

    private fun getLastMatchApi() {
        interactor?.let { it ->
            it.getLastMatchApi()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe { EventLeagueResponse ->
                    getView()?.let {
                        it.hideProgress()
                        it.putDataMatchList(EventLeagueResponse)
                    }
                }
        }
    }

    private fun getNextMatchApi() {
        interactor?.let { it ->
            it.getNextMatchApi()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe { EventLeagueResponse ->
                    getView()?.let {
                        it.hideProgress()
                        it.putDataMatchList(EventLeagueResponse)
                    }
                }
        }
    }


}