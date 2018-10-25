package com.github.footballclubsubmission.ui.fragments.matchlist

import com.github.footballclubsubmission.ui.fragments.matchlist.view.MatchListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
@Module
internal abstract class MatchListFragmentProvider {

    @ContributesAndroidInjector(modules = [MatchListFragmentModule::class])
    internal abstract fun provideMatchListFactory(): MatchListFragment

}