package com.github.footballclubsubmission.data.models

import com.google.gson.annotations.SerializedName

data class TeamsItem(

    @field:SerializedName("idTeam")
    var idTeam: String? = null,

    @field:SerializedName("strTeamBadge")
    var strTeamBadge: String? = null
)