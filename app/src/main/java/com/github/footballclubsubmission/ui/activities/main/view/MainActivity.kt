package com.github.footballclubsubmission.ui.activities.main.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.util.Log
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.data.models.EventsItem
import com.github.footballclubsubmission.ui.activities.matchDetail.view.MatchDetailActivity
import com.github.footballclubsubmission.ui.adapters.MatchListPagerAdapter
import com.github.footballclubsubmission.ui.base.view.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    internal lateinit var matchListPagerAdapter: MatchListPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        matchListPagerAdapter = MatchListPagerAdapter(supportFragmentManager)
        setUpMatchListPagerAdapter()
    }

    private fun setUpMatchListPagerAdapter() {
        matchListPagerAdapter.count = 2
        main_vp_match_list.adapter = matchListPagerAdapter
        main_tab_layout.addTab(main_tab_layout.newTab().setText(getString(R.string.title_last_match)))
        main_tab_layout.addTab(main_tab_layout.newTab().setText(getString(R.string.title_next_match)))
        main_vp_match_list.offscreenPageLimit = main_tab_layout.tabCount
        main_vp_match_list.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(main_tab_layout))
        main_tab_layout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab) {
                main_vp_match_list.currentItem = tab.position
            }
        })
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

}
