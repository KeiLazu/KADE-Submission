package com.github.footballclubsubmission.ui.fragments.matchList

import android.support.v7.widget.LinearLayoutManager
import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.ui.adapters.MatchListAdapter
import com.github.footballclubsubmission.ui.fragments.matchList.interactor.MatchListInteractor
import com.github.footballclubsubmission.ui.fragments.matchList.interactor.MatchListMvpInteractor
import com.github.footballclubsubmission.ui.fragments.matchList.presenter.MatchListMvpPresenter
import com.github.footballclubsubmission.ui.fragments.matchList.presenter.MatchListPresenter
import com.github.footballclubsubmission.ui.fragments.matchList.view.MatchListFragment
import com.github.footballclubsubmission.ui.fragments.matchList.view.MatchListMvpView
import dagger.Module
import dagger.Provides

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
@Module
class MatchListFragmentModule {

    @Provides
    internal fun provideMatchListInteractor(interactor: MatchListInteractor): MatchListMvpInteractor = interactor

    @Provides
    internal fun provideMatchListPresenter(presenter: MatchListPresenter<MatchListMvpView, MatchListMvpInteractor>)
            : MatchListMvpPresenter<MatchListMvpView, MatchListMvpInteractor> = presenter

    @Provides
    internal fun provideMatchListAdapter(): MatchListAdapter = MatchListAdapter(EventLeagueResponse(ArrayList()))

    @Provides
    internal fun provideLinearLayoutManager(fragment: MatchListFragment): LinearLayoutManager =
        LinearLayoutManager(fragment.activity)
}