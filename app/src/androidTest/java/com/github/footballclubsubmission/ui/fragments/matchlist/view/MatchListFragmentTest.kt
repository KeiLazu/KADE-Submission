package com.github.footballclubsubmission.ui.fragments.matchlist.view

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.ui.activities.main.view.MainActivity
import com.github.footballclubsubmission.ui.activities.matchdetail.view.MatchDetailActivity
import com.github.footballclubsubmission.ui.adapters.LastMatchListAdapter
import org.junit.After
import org.junit.Before

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
//        activityLoadLastMatches()
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun recyclerViewItemClickLastMatch() {
        onView(withId(R.id.match_list_rv_match)).check(matches(isDisplayed()))
        Thread.sleep(5000)
        onView(withId(R.id.match_list_rv_match)).check(matches(isDisplayed()))
        onView(withId(R.id.match_list_rv_match)).perform(RecyclerViewActions.actionOnItemAtPosition<LastMatchListAdapter.LastMatchViewHolder>(3, click()))
        intended(hasComponent(MatchDetailActivity::class.java.name))
    }

    @Test
    fun recyclerViewScrollItemClickNextMatch() {
        onView(withText(R.string.next_match_simple_name)).check(matches(isDisplayed()))
        onView(withText(R.string.next_match_simple_name)).perform(click())
        Thread.sleep(5000)
        onView(withId(R.id.match_list_rv_match)).check(matches(isDisplayed()))
        onView(withId(R.id.match_list_rv_match)).perform(RecyclerViewActions.scrollToPosition<LastMatchListAdapter.LastMatchViewHolder>(8))
        onView(withId(R.id.match_list_rv_match)).perform(RecyclerViewActions.actionOnItemAtPosition<LastMatchListAdapter.LastMatchViewHolder>(8, click()))
        intended(hasComponent(MatchDetailActivity::class.java.name))
    }

}