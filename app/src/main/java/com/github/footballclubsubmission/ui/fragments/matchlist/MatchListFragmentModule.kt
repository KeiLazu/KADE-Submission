package com.github.footballclubsubmission.ui.fragments.matchlist

import android.support.v7.widget.LinearLayoutManager
import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.ui.adapters.FavoriteListAdapter
import com.github.footballclubsubmission.ui.adapters.LastMatchListAdapter
import com.github.footballclubsubmission.ui.adapters.NextMatchListAdapter
import com.github.footballclubsubmission.ui.fragments.matchlist.interactor.MatchListInteractor
import com.github.footballclubsubmission.ui.fragments.matchlist.interactor.MatchListMvpInteractor
import com.github.footballclubsubmission.ui.fragments.matchlist.presenter.MatchListMvpPresenter
import com.github.footballclubsubmission.ui.fragments.matchlist.presenter.MatchListPresenter
import com.github.footballclubsubmission.ui.fragments.matchlist.view.MatchListFragment
import com.github.footballclubsubmission.ui.fragments.matchlist.view.MatchListMvpView
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
    internal fun provideLastMatchListAdapter(): LastMatchListAdapter = LastMatchListAdapter(EventLeagueResponse(ArrayList()))

    @Provides
    internal fun provideNextMatchListAdapter(): NextMatchListAdapter = NextMatchListAdapter(EventLeagueResponse(ArrayList()))

    @Provides
    internal fun provideFavoriteListAdapter(): FavoriteListAdapter = FavoriteListAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(fragment: MatchListFragment): LinearLayoutManager =
        LinearLayoutManager(fragment.activity)
}