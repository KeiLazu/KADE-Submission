package com.github.footballclubsubmission.di.builder

import com.github.footballclubsubmission.ui.activities.main.MainModule
import com.github.footballclubsubmission.ui.activities.main.view.MainActivity
import com.github.footballclubsubmission.ui.activities.matchdetail.MatchDetailModule
import com.github.footballclubsubmission.ui.activities.matchdetail.view.MatchDetailActivity
import com.github.footballclubsubmission.ui.fragments.matchlist.MatchListFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainModule::class),(MatchListFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(MatchDetailModule::class)])
    abstract fun bindMatchDetailActivity(): MatchDetailActivity

}