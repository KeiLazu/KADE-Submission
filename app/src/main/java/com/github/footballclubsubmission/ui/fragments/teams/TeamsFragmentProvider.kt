package com.github.footballclubsubmission.ui.fragments.teams

import com.github.footballclubsubmission.ui.fragments.teams.view.TeamsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/8/2018
 *  check https://github.com/KeiLazu for more
 */
@Module
abstract class TeamsFragmentProvider {

    @ContributesAndroidInjector(modules = [(TeamsFragmentModule::class)])
    internal abstract fun provideTeamsFragmentFactory(): TeamsFragment

}