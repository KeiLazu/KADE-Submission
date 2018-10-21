package com.github.footballclubsubmission.ui.activities.matchDetail

import com.github.footballclubsubmission.ui.activities.matchDetail.interactor.MatchDetailInteractor
import com.github.footballclubsubmission.ui.activities.matchDetail.interactor.MatchDetailMvpInteractor
import com.github.footballclubsubmission.ui.activities.matchDetail.presenter.MatchDetailMvpPresenter
import com.github.footballclubsubmission.ui.activities.matchDetail.presenter.MatchDetailPresenter
import com.github.footballclubsubmission.ui.activities.matchDetail.view.MatchDetailMvpView
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