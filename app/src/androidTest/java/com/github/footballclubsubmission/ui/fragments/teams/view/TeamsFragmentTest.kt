package com.github.footballclubsubmission.ui.fragments.teams.view

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.ui.activities.main.view.MainActivity
import com.github.footballclubsubmission.ui.activities.teamdetail.view.TeamDetailActivity
import com.github.footballclubsubmission.ui.adapters.NextMatchListAdapter
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Kei Lazu (Kennix Lazuardi) on 11/11/2018
 * check https://github.com/KeiLazu for more
 */
@RunWith(AndroidJUnit4::class)
class TeamsFragmentTest {

    @Rule
    @JvmField
    val mActivity = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun checkTeams() {
        onView(withId(R.id.teams)).check(matches(isDisplayed()))
        onView(withId(R.id.teams)).perform(click())
        onView(withId(R.id.teams_progress_bar)).check(matches(isDisplayed()))
    }

    @Test
    fun checkTeamsData() {
        checkTeams()
        Thread.sleep(5000)
        onView(withId(R.id.teams_spinner)).check(matches(isDisplayed()))
        onView(withId(R.id.teams_rv_teams)).perform(RecyclerViewActions.actionOnItemAtPosition<NextMatchListAdapter.NextMatchViewHolder>(1, click()))
        intended(hasComponent(TeamDetailActivity::class.java.name))
    }

}