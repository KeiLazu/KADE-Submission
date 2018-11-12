package com.github.footballclubsubmission.ui.fragments.teamplayer

import com.github.footballclubsubmission.ui.fragments.teamplayer.view.TeamPlayerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/12/2018
 *  check https://github.com/KeiLazu for more
 */
@Module
abstract class TeamPlayerProvider {

    @ContributesAndroidInjector(modules = [(TeamPlayerModule::class)])
    internal abstract fun bindTeamPlayerFragmentFactory(): TeamPlayerFragment

}