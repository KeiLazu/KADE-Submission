package com.github.footballclubsubmission.data.network

import org.junit.Test

import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

/**
 * Created by Kei Lazu (Kennix Lazuardi) on 10/30/2018
 * check https://github.com/KeiLazu for more
 */
class AppApiHelperTest {

    @Test
    fun getLastMatchApi() {
        val appApiHelper = mock(AppApiHelper::class.java)
        appApiHelper.getLastMatchApi()
        verify(appApiHelper).getLastMatchApi()
    }

    @Test
    fun getNextMatchApi() {
        val appApiHelper = mock(AppApiHelper::class.java)
        appApiHelper.getNextMatchApi()
        verify(appApiHelper).getNextMatchApi()
    }

    @Test
    fun getEventDetailApi() {
        val appApiHelper = mock(AppApiHelper::class.java)
        appApiHelper.getEventDetailApi(4328)
        verify(appApiHelper).getEventDetailApi(4328)
    }

    @Test
    fun getTeamBadgeApi() {
        val appApiHelper = mock(AppApiHelper::class.java)
        appApiHelper.getTeamBadgeApi(133616)
        verify(appApiHelper).getTeamBadgeApi(133616)
    }

}