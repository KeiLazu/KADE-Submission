package com.github.footballclubsubmission.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.github.footballclubsubmission.ui.fragments.matchlist.view.MatchListFragment
import javax.inject.Inject


/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/8/2018
 *  check https://github.com/KeiLazu for more
 */
class MatchListPagerAdapter @Inject internal constructor(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {

    private var tabCount = 0

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> MatchListFragment.newInstance(MatchListFragment.DISPLAY_MODE_LAST_MATCH)
            1 -> MatchListFragment.newInstance(MatchListFragment.DISPLAY_MODE_NEXT_MATCH)
            else -> null
        }
    }

    override fun getCount(): Int = tabCount

    fun setCount(totalFragment: Int) {
        tabCount = totalFragment
    }

}