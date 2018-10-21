package com.github.footballclubsubmission.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.github.footballclubsubmission.ui.fragments.matchList.view.MatchListFragment

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
class MatchListPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private var tabCount = 0

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> MatchListFragment.newInstance(MatchListFragment.DISPLAY_MODE_LAST_MATCH)
            1 -> MatchListFragment.newInstance(MatchListFragment.DISPLAY_MODE_NEXT_MATCH)
            else -> null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

    internal fun setCount(count: Int) {
        this.tabCount = count
    }

}