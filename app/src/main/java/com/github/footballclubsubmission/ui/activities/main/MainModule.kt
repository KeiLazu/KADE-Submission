package com.github.footballclubsubmission.ui.activities.main

import com.github.footballclubsubmission.ui.activities.main.view.MainActivity
import com.github.footballclubsubmission.ui.adapters.MatchListPagerAdapter
import dagger.Module
import dagger.Provides

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/8/2018
 *  check https://github.com/KeiLazu for more
 */
@Module
class MainModule {

    @Provides
    internal fun provideMatchListPagerAdapter(activity: MainActivity): MatchListPagerAdapter = MatchListPagerAdapter(activity.supportFragmentManager)

}