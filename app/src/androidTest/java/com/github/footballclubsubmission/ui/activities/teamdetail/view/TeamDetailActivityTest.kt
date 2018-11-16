package com.github.footballclubsubmission.ui.activities.teamdetail.view

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.github.footballclubsubmission.R
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
        val intent = Intent()
        intent.putExtra(TeamDetailActivity.EXTRA_TEAM_ID, 133604)
        mActivity.launchActivity(intent)
    }

    @After
    fun tearDown() {
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

}