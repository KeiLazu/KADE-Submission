package com.github.footballclubsubmission.ui.activities.matchdetail

import com.github.footballclubsubmission.ui.activities.matchdetail.interactor.MatchDetailInteractor
import com.github.footballclubsubmission.ui.activities.matchdetail.interactor.MatchDetailMvpInteractor
import com.github.footballclubsubmission.ui.activities.matchdetail.presenter.MatchDetailMvpPresenter
import com.github.footballclubsubmission.ui.activities.matchdetail.presenter.MatchDetailPresenter
import com.github.footballclubsubmission.ui.activities.matchdetail.view.MatchDetailMvpView
import dagger.Module
import dagger.Provides

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/21/2018
 *  check https://github.com/KeiLazu for more
 */
@Module
class MatchDetailModule {

    @Provides
    internal fun provideMatchDetailInteractor(matchDetailInteractor: MatchDetailInteractor): MatchDetailMvpInteractor = matchDetailInteractor

    @Provides
    internal fun provideMatchDetailPresenter(matchDetailPresenter: MatchDetailPresenter<MatchDetailMvpView, MatchDetailMvpInteractor>)
            : MatchDetailMvpPresenter<MatchDetailMvpView, MatchDetailMvpInteractor> = matchDetailPresenter

}