package com.github.footballclubsubmission.ui.fragments.teamdescription

import com.github.footballclubsubmission.ui.fragments.teamdescription.view.TeamDescriptionFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/12/2018
 *  check https://github.com/KeiLazu for more
 */
@Module
abstract class TeamDescriptionProvider {

    @ContributesAndroidInjector
    internal abstract fun bindTeamDescriptionFragmentFactory(): TeamDescriptionFragment

}