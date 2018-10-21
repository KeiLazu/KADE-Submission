package com.github.footballclubsubmission.di.builder

import com.github.footballclubsubmission.ui.activities.main.view.MainActivity
import com.github.footballclubsubmission.ui.activities.matchDetail.MatchDetailModule
import com.github.footballclubsubmission.ui.activities.matchDetail.view.MatchDetailActivity
import com.github.footballclubsubmission.ui.fragments.matchList.MatchListFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MatchListFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(MatchDetailModule::class)])
    abstract fun bindMatchDetailActivity(): MatchDetailActivity

}