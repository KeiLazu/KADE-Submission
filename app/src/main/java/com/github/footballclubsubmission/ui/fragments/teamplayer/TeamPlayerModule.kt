package com.github.footballclubsubmission.ui.fragments.teamplayer

import com.github.footballclubsubmission.ui.fragments.teamplayer.interactor.TeamPlayerInteractor
import com.github.footballclubsubmission.ui.fragments.teamplayer.interactor.TeamPlayerMvpInteractor
import com.github.footballclubsubmission.ui.fragments.teamplayer.presenter.TeamPlayerMvpPresenter
import com.github.footballclubsubmission.ui.fragments.teamplayer.presenter.TeamPlayerPresenter
import com.github.footballclubsubmission.ui.fragments.teamplayer.view.TeamPlayerMvpView
import dagger.Module
import dagger.Provides

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/12/2018
 *  check https://github.com/KeiLazu for more
 */
@Module
class TeamPlayerModule {

    @Provides
    internal fun provideTeamPlayerInteractor(interactor: TeamPlayerInteractor): TeamPlayerMvpInteractor = interactor

    @Provides
    internal fun provideTeamPlayerPresenter(presenter: TeamPlayerPresenter<TeamPlayerMvpView, TeamPlayerMvpInteractor>)
            : TeamPlayerMvpPresenter<TeamPlayerMvpView, TeamPlayerMvpInteractor> = presenter

}