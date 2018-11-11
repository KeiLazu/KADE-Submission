package com.github.footballclubsubmission.ui.fragments.matchlist.presenter

import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.ui.fragments.matchlist.interactor.MatchListMvpInteractor
import com.github.footballclubsubmission.ui.fragments.matchlist.view.MatchListMvpView
import com.github.footballclubsubmission.utils.TestSchedulerProvider
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import org.junit.After
import org.junit.Before

import org.junit.Test

/**
 * Created by Kei Lazu (Kennix Lazuardi) on 11/3/2018
 * check https://github.com/KeiLazu for more
 */
class MatchListPresenterTest {

    private lateinit var presenter: MatchListPresenter<MatchListMvpView, MatchListMvpInteractor>
    private var mView: MatchListMvpView = mock()
    private var mInteractor: MatchListMvpInteractor = mock()

    @Before
    fun setUp() {
        val compositeDisposable: CompositeDisposable = mock()
        presenter = MatchListPresenter(mInteractor, TestSchedulerProvider(), compositeDisposable)
        presenter.onAttach(mView)
    }

    @After
    fun tearDown() {
        presenter.onDetach()
    }

    @Test
    fun getLastMatchApi() {
        val eventLeagueResponseMocked: EventLeagueResponse = mock()

        doReturn(Observable.just(eventLeagueResponseMocked))
            .`when`(mInteractor)
            .getLastMatchApi()

        presenter.getLastMatchApi()

        verify(mView).putLastMatchData(eventLeagueResponseMocked)
        verify(mView).hideProgress()
    }

    @Test
    fun getNextMatchApi() {
        val eventLeagueResponseMocked: EventLeagueResponse = mock()

        doReturn(Observable.just(eventLeagueResponseMocked))
            .`when`(mInteractor)
            .getNextMatchApi()

        presenter.getNextMatchApi()

        verify(mView).putLastMatchData(eventLeagueResponseMocked)
        verify(mView).hideProgress()
    }

}