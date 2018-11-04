package com.github.footballclubsubmission.ui.activities.matchdetail.presenter

import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.data.models.EventsItem
import com.github.footballclubsubmission.data.network.ApiHelper
import com.github.footballclubsubmission.data.network.AppApiHelper
import com.github.footballclubsubmission.ui.activities.matchdetail.interactor.MatchDetailInteractor
import com.github.footballclubsubmission.ui.activities.matchdetail.interactor.MatchDetailMvpInteractor
import com.github.footballclubsubmission.ui.activities.matchdetail.view.MatchDetailActivity
import com.github.footballclubsubmission.ui.activities.matchdetail.view.MatchDetailMvpView
import com.github.footballclubsubmission.utils.TestSchedulerProvider
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify

/**
 * Created by Kei Lazu (Kennix Lazuardi) on 10/30/2018
 * check https://github.com/KeiLazu for more
 */
class MatchDetailPresenterTest {

    private lateinit var presenter: MatchDetailPresenter<MatchDetailMvpView, MatchDetailMvpInteractor>
    val mView: MatchDetailActivity = mock()
    val mInteractor: MatchDetailInteractor = mock()

    @Before
    fun setUp() {
        val compositeDisposable = CompositeDisposable()
        presenter = MatchDetailPresenter(mInteractor, TestSchedulerProvider(), compositeDisposable)
        presenter.onAttach(mView)
    }

    @Test
    fun getEventDetail() {
        val eventLeagueResponseMocked: EventLeagueResponse = mock()

        doReturn(Observable.just(eventLeagueResponseMocked))
            .`when`(mInteractor)
            .getEventDetailApi(4328)

        presenter.getEventDetail(4328)

        verify(mView).showProgress()
        verify(mView).displayEventDetail(eventLeagueResponseMocked)
        verify(mView).hideProgress()

    }

    @Test
    fun getTeamBadge() {
    }

    @Test
    fun addToFav() {
    }
}