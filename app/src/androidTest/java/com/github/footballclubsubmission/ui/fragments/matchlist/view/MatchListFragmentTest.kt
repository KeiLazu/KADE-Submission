package com.github.footballclubsubmission.ui.fragments.matchlist.view

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.base.IdlingResourceRegistry
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.ui.activities.main.view.MainActivity
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Kei Lazu (Kennix Lazuardi) on 11/5/2018
 * check https://github.com/KeiLazu for more
 */
@RunWith(AndroidJUnit4::class)
class MatchListFragmentTest {

    @Rule
    @JvmField
    val mActivity = ActivityTestRule(MainActivity::class.java, true,true)

    @Before
    fun setUp() {
        mActivity.activity.settingFragment(R.id.main_fragment_container,
            MatchListFragment.newInstance(MatchListFragment.DISPLAY_MODE_LAST_MATCH),
            MatchListFragment.getSimpleName(mActivity.activity, MatchListFragment.DISPLAY_MODE_LAST_MATCH))

    }

    @After
    fun tearDown() {
    }

    @Test
    fun recyclerViewCheckScrollClick() {
        onView(withId(R.id.match_list_rv_match)).check(matches(isDisplayed()))
        Thread.sleep(5000)
        onView(withText("Man City")).check(matches(isDisplayed()))
        onView(withText("Man City")).perform(click())
    }

}