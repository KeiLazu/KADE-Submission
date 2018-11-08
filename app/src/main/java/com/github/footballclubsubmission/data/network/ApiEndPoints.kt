package com.github.footballclubsubmission.data.network

import android.net.Uri
import com.github.footballclubsubmission.BuildConfig

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
object ApiEndPoints {

    private fun getBaseTheSportsDbUrl(): Uri.Builder {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("api")
            .appendPath("v1")
            .appendPath("json")
            .appendPath(BuildConfig.TSDB_API_KEY)
    }
    
    fun getLastMatchUrl(): String {
        return getBaseTheSportsDbUrl()
            .appendPath("eventspastleague.php")
            .appendQueryParameter("id", "4328")
            .build()
            .toString()
    }

    fun getNextMatchUrl(): String {
        return getBaseTheSportsDbUrl()
            .appendPath("eventsnextleague.php")
            .appendQueryParameter("id", "4328")
            .build()
            .toString()
    }

    fun getEventDetailUrl(eventId: Int): String {
        return getBaseTheSportsDbUrl()
            .appendPath("lookupevent.php")
            .appendQueryParameter("id", eventId.toString())
            .build()
            .toString()
    }

    fun getTeamBadgeUrl(teamId: Int): String {
        return getBaseTheSportsDbUrl()
            .appendPath("lookupteam.php")
            .appendQueryParameter("id", teamId.toString())
            .build()
            .toString()
    }

    fun getAllLeaguesUrl(): String {
        return getBaseTheSportsDbUrl()
            .appendPath("all_leagues.php")
            .build().toString()
    }

}