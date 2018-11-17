package com.github.footballclubsubmission.ui.activities.teamdetail.view

import android.content.Intent
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
import android.support.v7.widget.RecyclerView
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.ui.activities.playerdetail.view.PlayerDetailActivity
import com.github.footballclubsubmission.ui.adapters.PlayerListAdapter
import org.hamcrest.Matchers.not
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Kei Lazu (Kennix Lazuardi) on 11/13/2018
 * check https://github.com/KeiLazu for more
 */
@RunWith(AndroidJUnit4::class)
class TeamDetailActivityTest {

    @Rule
    @JvmField
    val mActivity = ActivityTestRule(TeamDetailActivity::class.java, true, false)

    @Before
    fun setUp() {
        Intents.init()
        val intent = Intent()
        intent.putExtra(TeamDetailActivity.EXTRA_TEAM_ID, 133604)
        mActivity.launchActivity(intent)
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun checkInfoTab() {
        Thread.sleep(5000)
        onView(withText(R.string.text_overview_team)).check(matches(isDisplayed()))
        onView(withText(R.string.text_player_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.include_collapsable_team_detail_img_badge)).check(matches(isDisplayed()))
        onView(withId(R.id.include_collapsable_team_detail_tv_year)).check(matches(isDisplayed()))
        onView(withId(R.id.include_collapsable_team_detail_tv_manager)).check(matches(isDisplayed()))
    }

    @Test
    fun checkInfoClicked() {
        checkInfoTab()
        onView(withText(R.string.text_player_detail)).perform(click())
        onView(withText(R.string.text_overview_team)).perform(click())
    }

    @Test
    fun checkPlayerClicked() {
        checkInfoTab()
        onView(withText(R.string.text_player_detail)).perform(click())
        onView(withId(R.id.team_player_rv_player_list)).check(matches(isDisplayed()))
//        onView(withId(R.id.team_player_rv_player_list)).perform(RecyclerViewActions.scrollToPosition<PlayerListAdapter.ViewHolder>(5))
//        onView(withId(R.id.team_player_rv_player_list)).perform(RecyclerViewActions.actionOnItemAtPosition<PlayerListAdapter.ViewHolder>(5, click()))
        onView(withId(R.id.team_player_rv_player_list)).let {
            it.perform(RecyclerViewActions.scrollToPosition<PlayerListAdapter.ViewHolder>(5))
            it.perform(RecyclerViewActions.actionOnItemAtPosition<PlayerListAdapter.ViewHolder>(5, click()))
            intended(hasComponent(PlayerDetailActivity::class.java.name))
        }
    }

}