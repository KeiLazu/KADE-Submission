package com.github.footballclubsubmission.ui.activities.main.view

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.github.footballclubsubmission.R
import org.hamcrest.CoreMatchers.not
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Kei Lazu (Kennix Lazuardi) on 11/8/2018
 * check https://github.com/KeiLazu for more
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val mActivity = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun checkTabName() {
        onView(withText(R.string.last_match_simple_name)).check(matches(isDisplayed()))
        onView(withText(R.string.next_match_simple_name)).check(matches(isDisplayed()))
        onView(withText(R.string.next_match_simple_name)).perform(click())
        onView(withText(R.string.last_match_simple_name)).perform(click())
    }

    @Test
    fun checkFavorites() {
        onView(withId(R.id.favorites)).check(matches(isDisplayed()))
        onView(withId(R.id.favorites)).perform(click())
        onView(withId(R.id.main_fragment_container)).check(matches(isDisplayed()))
    }

    @Test
    fun checkFavAndBack() {
        checkFavorites()
        onView(withId(R.id.matches)).check(matches(isDisplayed()))
        onView(withId(R.id.matches)).perform(click())
        onView(withId(R.id.main_fragment_container)).check(matches(not(isDisplayed())))
    }

}