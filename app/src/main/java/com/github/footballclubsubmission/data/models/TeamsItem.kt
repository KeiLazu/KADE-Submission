package com.github.footballclubsubmission.data.models

import com.google.gson.annotations.SerializedName

data class TeamsItem(

    @field:SerializedName("idTeam")
    var idTeam: Long? = 0,

    @field:SerializedName("strTeamBadge")
    var strTeamBadge: String? = null,

    @field:SerializedName("intFormedYear")
    var intFormedYear: Int? = null,

    @field:SerializedName("strTeam")
    var strTeam: String? = null,

    @field:SerializedName("strDescriptionEN")
    var strDescriptionEN: String? = null,

    @field:SerializedName("strManager")
    var strManager: String? = null,

    @field:SerializedName("strStadium")
    var strStadium: String? = null,

    @field:SerializedName("strStadiumThumb")
    var strStadiumThumb: String? = null,

    @field:SerializedName("strStadiumDescription")
    var strStadiumDescription: String? = null

)