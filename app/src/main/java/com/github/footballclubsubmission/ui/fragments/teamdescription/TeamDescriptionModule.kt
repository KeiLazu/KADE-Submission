package com.github.footballclubsubmission.ui.fragments.teamdescription

import com.github.footballclubsubmission.ui.fragments.teamdescription.interactor.TeamDescriptionInteractor
import com.github.footballclubsubmission.ui.fragments.teamdescription.interactor.TeamDescriptionMvpInteractor
import com.github.footballclubsubmission.ui.fragments.teamdescription.presenter.TeamDescriptionMvpPresenter
import com.github.footballclubsubmission.ui.fragments.teamdescription.presenter.TeamDescriptionPresenter
import com.github.footballclubsubmission.ui.fragments.teamdescription.view.TeamDescriptionMvpView
import dagger.Module
import dagger.Provides

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/12/2018
 *  check https://github.com/KeiLazu for more
 */
@Module
class TeamDescriptionModule {

    @Provides
    internal fun provideTeamDescriptionInteractor(interactor: TeamDescriptionInteractor): TeamDescriptionMvpInteractor
            = interactor

    @Provides
    internal fun provideTeamDescriptionPresenter(presenter: TeamDescriptionPresenter<TeamDescriptionMvpView, TeamDescriptionMvpInteractor>)
            : TeamDescriptionMvpPresenter<TeamDescriptionMvpView, TeamDescriptionMvpInteractor> = presenter

}