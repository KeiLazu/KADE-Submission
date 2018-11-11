package com.github.footballclubsubmission.ui.activities.main.view

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.View
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.R.id.*
import com.github.footballclubsubmission.ui.adapters.MatchListPagerAdapter
import com.github.footballclubsubmission.ui.base.view.BaseActivity
import com.github.footballclubsubmission.ui.fragments.matchlist.view.MatchListFragment
import com.github.footballclubsubmission.ui.fragments.teams.view.TeamsFragment
import com.github.footballclubsubmission.utils.invisible
import com.github.footballclubsubmission.utils.visible
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), HasSupportFragmentInjector, TabLayout.OnTabSelectedListener {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    internal lateinit var mMatchListPagerAdapter: MatchListPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initWidgets(savedInstanceState)
        setUpMatchesListPagerView()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector
    override fun onFragmentAttached() {}
    override fun onFragmentDetached(tag: String) {}

    private fun setUpMatchesListPagerView() {
        mMatchListPagerAdapter.count = 2
        main_vp_matches.adapter = mMatchListPagerAdapter
        main_tab_layout.addTab(main_tab_layout.newTab().setText(getString(R.string.last_match_simple_name)))
        main_tab_layout.addTab(main_tab_layout.newTab().setText(getString(R.string.next_match_simple_name)))
        main_vp_matches.offscreenPageLimit = main_tab_layout.tabCount
        main_vp_matches.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(main_tab_layout))
        main_tab_layout.addOnTabSelectedListener(this)
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {}

    override fun onTabUnselected(tab: TabLayout.Tab?) {}

    override fun onTabSelected(tab: TabLayout.Tab?) = main_vp_matches.let { it.currentItem = tab?.position ?: 0 }

    private fun initWidgets(savedInstanceState: Bundle?) {
        main_bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                matches -> setPrevMatchFragment()
                teams -> setTeamsFragment(savedInstanceState)
                favorites -> setFavoriteFragment(savedInstanceState)
            }
            true
        }
        main_bottom_navigation.selectedItemId = matches
    }

    private fun settingFragment(@IdRes layoutId: Int, fragment: Fragment, simpleNameTag: String) =
        supportFragmentManager.beginTransaction().replace(layoutId, fragment, simpleNameTag).commit()

    private fun setPrevMatchFragment() {
        if (supportFragmentManager.findFragmentById(R.id.main_fragment_container) is MatchListFragment) {
            supportFragmentManager.beginTransaction().remove(
                supportFragmentManager.findFragmentById(R.id.main_fragment_container)
            ).commit()
        }
        checkVisibilityFragmentContainer(true)
    }

    private fun checkVisibilityFragmentContainer(isHome: Boolean) {
        if (isHome) {
            if (main_fragment_container.visibility == View.VISIBLE) {
                main_fragment_container.invisible()
            }
        } else {
            if (main_fragment_container.visibility == View.INVISIBLE) {
                main_fragment_container.visible()
            }
        }
    }

    private fun setFavoriteFragment(savedInstanceState: Bundle?) {
        checkVisibilityFragmentContainer(false)
        if (savedInstanceState == null) {
            settingFragment(
                R.id.main_fragment_container,
                MatchListFragment.newInstance(MatchListFragment.DISPLAY_MODE_FAV),
                MatchListFragment.getSimpleName(this, MatchListFragment.DISPLAY_MODE_FAV)
            )
        }
    }

    private fun setTeamsFragment(savedInstanceState: Bundle?) {
        checkVisibilityFragmentContainer(false)
        if (savedInstanceState == null) {
            settingFragment(
                R.id.main_fragment_container,
                TeamsFragment.getInstance(),
                TeamsFragment::class.java.simpleName
            )
        }
    }

}
