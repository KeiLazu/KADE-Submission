package com.github.footballclubsubmission.ui.activities.teamdetail

import com.github.footballclubsubmission.ui.activities.teamdetail.interactor.TeamDetailInteractor
import com.github.footballclubsubmission.ui.activities.teamdetail.interactor.TeamDetailMvpInteractor
import com.github.footballclubsubmission.ui.activities.teamdetail.presenter.TeamDetailMvpPresenter
import com.github.footballclubsubmission.ui.activities.teamdetail.presenter.TeamDetailPresenter
import com.github.footballclubsubmission.ui.activities.teamdetail.view.TeamDetailMvpView
import dagger.Module
import dagger.Provides

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/10/2018
 *  check https://github.com/KeiLazu for more
 */
@Module
class TeamDetailModule {

    @Provides
    internal fun provideTeamDetailInteractor(interactor: TeamDetailInteractor): TeamDetailMvpInteractor = interactor

    @Provides
    internal fun provideTeamDetailPresenter(presenter: TeamDetailPresenter<TeamDetailMvpView, TeamDetailMvpInteractor>)
            : TeamDetailMvpPresenter<TeamDetailMvpView, TeamDetailMvpInteractor> = presenter

}