package com.github.footballclubsubmission.ui.activities.main.view

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.R.id.*
import com.github.footballclubsubmission.ui.base.view.BaseActivity
import com.github.footballclubsubmission.ui.fragments.matchlist.view.MatchListFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initWidgets(savedInstanceState)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector
    override fun onFragmentAttached() {}
    override fun onFragmentDetached(tag: String) {}

    private fun initWidgets(savedInstanceState: Bundle?) {
        main_bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                prev_match -> setPrevMatchFragment(savedInstanceState)
                next_match -> setNextMatchFragment(savedInstanceState)
                favorites -> {
                }
            }
            true
        }
        main_bottom_navigation.selectedItemId = prev_match
    }

    private fun settingFragment(@IdRes layoutId: Int, fragment: Fragment, simpleNameTag: String) =
        supportFragmentManager.beginTransaction().replace(layoutId, fragment, simpleNameTag).commit()

    private fun setPrevMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null)
            settingFragment(
                R.id.main_fragment_container,
                MatchListFragment.newInstance(MatchListFragment.DISPLAY_MODE_LAST_MATCH),
                MatchListFragment.getSimpleName(this, MatchListFragment.DISPLAY_MODE_LAST_MATCH)
            )
    }

    private fun setNextMatchFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null)
            settingFragment(
                R.id.main_fragment_container,
                MatchListFragment.newInstance(MatchListFragment.DISPLAY_MODE_NEXT_MATCH),
                MatchListFragment.getSimpleName(this, MatchListFragment.DISPLAY_MODE_NEXT_MATCH)
            )
    }

}
