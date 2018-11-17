package com.github.footballclubsubmission.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.github.footballclubsubmission.ui.fragments.matchlist.view.MatchListFragment
import javax.inject.Inject

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/17/2018
 *  check https://github.com/KeiLazu for more
 */
class FavoritePagerAdapter @Inject internal constructor(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    private var tabCount = 2

    override fun getItem(position: Int): Fragment? =
        when (position) {
            0 -> MatchListFragment.newInstance(MatchListFragment.DISPLAY_MODE_FAV_MATCH)
            1 -> MatchListFragment.newInstance(MatchListFragment.DISPLAY_MODE_FAV_TEAMS)
            else -> null
        }

    override fun getCount(): Int = tabCount

}