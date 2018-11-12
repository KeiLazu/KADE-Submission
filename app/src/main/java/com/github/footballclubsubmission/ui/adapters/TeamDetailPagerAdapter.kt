package com.github.footballclubsubmission.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.github.footballclubsubmission.data.models.TeamsItem
import com.github.footballclubsubmission.ui.fragments.teamdescription.view.TeamDescriptionFragment
import com.github.footballclubsubmission.ui.fragments.teamplayer.view.TeamPlayerFragment
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/12/2018
 *  check https://github.com/KeiLazu for more
 */
class TeamDetailPagerAdapter internal constructor(fragmentManager: FragmentManager, private val teamsItem: TeamsItem)
    : FragmentPagerAdapter(fragmentManager) {

    private val mTabCount = 2

    override fun getItem(position: Int): Fragment? =
        when (position) {
            0 -> teamsItem.let { TeamDescriptionFragment.newInstance(it.strStadium, it.strStadiumThumb, it.strStadiumDescription, it.strDescriptionEN) }
            1 -> TeamPlayerFragment.newInstance(teamsItem.idTeam?.toInt() ?: 0)
            else -> null
        }

    override fun getCount(): Int = mTabCount

}