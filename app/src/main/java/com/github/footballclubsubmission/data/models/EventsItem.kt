package com.github.footballclubsubmission.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EventsItem(

    @field:SerializedName("intHomeShots")
    var intHomeShots: String? = "0",

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
    var idEvent: Int? = 0,

    @field:SerializedName("strHomeYellowCards")
    var strHomeYellowCards: String? = null,

    @field:SerializedName("idHomeTeam")
    var idHomeTeam: String? = null,

    @field:SerializedName("intHomeScore")
    var intHomeScore: String? = "0",

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
    var intAwayShots: String? = "0",

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
    var intAwayScore: String? = "0"
) : Parcelable