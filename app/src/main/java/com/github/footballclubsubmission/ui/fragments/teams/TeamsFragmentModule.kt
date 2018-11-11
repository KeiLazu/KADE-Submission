package com.github.footballclubsubmission.ui.fragments.teams

import android.support.v7.widget.LinearLayoutManager
import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.ui.adapters.TeamListAdapter
import com.github.footballclubsubmission.ui.fragments.teams.interactor.TeamsInteractor
import com.github.footballclubsubmission.ui.fragments.teams.interactor.TeamsMvpInteractor
import com.github.footballclubsubmission.ui.fragments.teams.presenter.TeamsMvpPresenter
import com.github.footballclubsubmission.ui.fragments.teams.presenter.TeamsPresenter
import com.github.footballclubsubmission.ui.fragments.teams.view.TeamsFragment
import com.github.footballclubsubmission.ui.fragments.teams.view.TeamsMvpView
import dagger.Module
import dagger.Provides

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/8/2018
 *  check https://github.com/KeiLazu for more
 */
@Module
class TeamsFragmentModule {

    @Provides
    internal fun provideTeamsInteractor(interactor: TeamsInteractor): TeamsMvpInteractor = interactor

    @Provides
    internal fun provideTeamsPresenter(presenter: TeamsPresenter<TeamsMvpView, TeamsMvpInteractor>)
            : TeamsMvpPresenter<TeamsMvpView, TeamsMvpInteractor> = presenter

    @Provides
    internal fun provideLinearLayoutManager(fragment: TeamsFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)

    @Provides
    internal fun provideTeamListAdapter(): TeamListAdapter = TeamListAdapter(TeamResponse(ArrayList()))

}