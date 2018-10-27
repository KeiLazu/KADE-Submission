package com.github.footballclubsubmission.data.db.favoritematch

import com.google.gson.annotations.SerializedName

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/25/2018
 *  check https://github.com/KeiLazu for more
 */

data class FavoriteMatchModel(

    @field:SerializedName("isFavorite")
    var isFavorite: Boolean? = false,

    @field:SerializedName("intHomeShots")
    var intHomeShots: String? = null,

    @field:SerializedName("strHomeLineupDefense")
    var strHomeLineupDefense: String? = null,

    @field:SerializedName("strAwayLineupSubstitutes")
    var strAwayLineupSubstitutes: String? = null,

    @field:SerializedName("strHomeLineupForward")
    var strHomeLineupForward: String? = null,

    @field:SerializedName("strHomeGoalDetails")
    var strHomeGoalDetails: String? = null,

    @field:SerializedName("strAwayLineupGoalkeeper")
    var strAwayLineupGoalkeeper: String? = null,

    @field:SerializedName("strAwayLineupMidfield")
    var strAwayLineupMidfield: String? = null,

    @field:SerializedName("idEvent")
    var idEvent: String? = null,

    @field:SerializedName("strHomeYellowCards")
    var strHomeYellowCards: String? = null,

    @field:SerializedName("idHomeTeam")
    var idHomeTeam: String? = null,

    @field:SerializedName("intHomeScore")
    var intHomeScore: String? = null,

    @field:SerializedName("dateEvent")
    var dateEvent: String? = null,

    @field:SerializedName("strAwayTeam")
    var strAwayTeam: String? = null,

    @field:SerializedName("strHomeLineupMidfield")
    var strHomeLineupMidfield: String? = null,

    @field:SerializedName("strDate")
    var strDate: String? = null,

    @field:SerializedName("idAwayTeam")
    var idAwayTeam: String? = null,

    @field:SerializedName("strAwayRedCards")
    var strAwayRedCards: String? = null,

    @field:SerializedName("intAwayShots")
    var intAwayShots: String? = null,

    @field:SerializedName("strFilename")
    var strFilename: String? = null,

    @field:SerializedName("strTime")
    var strTime: String? = null,

    @field:SerializedName("strAwayGoalDetails")
    var strAwayGoalDetails: String? = null,

    @field:SerializedName("strAwayLineupForward")
    var strAwayLineupForward: String? = null,

    @field:SerializedName("strHomeRedCards")
    var strHomeRedCards: String? = null,

    @field:SerializedName("strHomeLineupGoalkeeper")
    var strHomeLineupGoalkeeper: String? = null,

    @field:SerializedName("strHomeLineupSubstitutes")
    var strHomeLineupSubstitutes: String? = null,

    @field:SerializedName("strAwayYellowCards")
    var strAwayYellowCards: String? = null,

    @field:SerializedName("strAwayLineupDefense")
    var strAwayLineupDefense: String? = null,

    @field:SerializedName("strHomeTeam")
    var strHomeTeam: String? = null,

    @field:SerializedName("intAwayScore")
    var intAwayScore: String? = null,

    @field:SerializedName("strHomeBadge")
    var strHomeBadge: String? = null,

    @field:SerializedName("strAwayBadge")
    var strAwayBadge: String? = null
) {
    companion object {
        const val ID: String = "ID"
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE"
        const val IS_FAVORITE: String = "IS_FAV"
        const val HOME_SHOTS: String = "HOME_SHOTS"
        const val HOME_LINEUP_DEFENSE: String = "HOME_DEFENSE"
        const val AWAY_LINEUP_SUBS: String = "AWAY_SUBS"
        const val HOME_LINEUP_FORWARD: String = "HOME_FORWARD"
        const val HOME_GOAL_DETAIL: String = "HOME_GOAL_DETAIL"
        const val AWAY_LINEUP_GOALKEEPER: String = "AWAY_GOALKEEPER"
        const val AWAY_LINEUP_MIDFIELD: String = "AWAY_MIDFIELD"
        const val ID_EVENT: String = "ID_EVENT"
        const val HOME_YELLOW_CARDS: String = "HOME_YELLOW_CARDS"
        const val HOME_TEAM_ID: String = "ID_HOME"
        const val HOME_SCORE: String = "HOME_SCORE"
        const val DATE_EVENT: String = "DATE_EVENT"
        const val AWAY_TEAM: String = "AWAY_TEAM"
        const val HOME_LINEUP_MIDFIELD: String = "HOME_MIDFIELD"
        const val DATE: String = "DATE"
        const val AWAY_TEAM_ID: String = "ID_AWAY"
        const val AWAY_RED_CARDS: String = "AWAY_RED_CARDS"
        const val AWAY_SHOTS: String = "AWAY_SHOTS"
        const val FILENAME: String = "FILENAME"
        const val TIME: String = "TIME"
        const val AWAY_GOAL_DETAIL: String = "AWAY_GOAL_DETAIL"
        const val AWAY_LINEUP_FORWARD: String = "AWAY_FORWARD"
        const val HOME_RED_CARDS: String = "HOME_RED_CARDS"
        const val HOME_LINEUP_GOALKEEPER: String = "HOME_GOALKEEPER"
        const val HOME_LINEUP_SUBS: String = "HOME_SUBS"
        const val AWAY_YELLOW_CARDS: String = "AWAY_YELLOW_CARDS"
        const val AWAY_LINEUP_DEFENSE: String = "AWAY_DEFENSE"
        const val HOME_TEAM: String = "HOME_TEAM"
        const val AWAY_SCORE: String = "AWAY_SCORE"
        const val HOME_BADGE: String = "HOME_BADGE"
        const val AWAY_BADGE: String = "AWAY_BADGE"
    }
}