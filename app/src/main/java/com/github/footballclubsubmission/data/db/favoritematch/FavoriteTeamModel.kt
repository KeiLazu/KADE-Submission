package com.github.footballclubsubmission.data.db.favoritematch

import com.google.gson.annotations.SerializedName
import java.net.IDN

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/17/2018
 *  check https://github.com/KeiLazu for more
 */
data class FavoriteTeamModel(
    @field:SerializedName("ID")
    var intId: Int? = null,

    @field:SerializedName("strTeamBadge")
    var teamBadge: String? = null,

    @field:SerializedName("strTeam")
    var teamName: String? = null,

    @field:SerializedName("idTeam")
    var teamId: Long? = 0
) {
    companion object {
        const val ID: String = "ID"
        const val TABLE_FAV_TEAM : String = "TABLE_FAV_TEAM"
        const val TEAM_BADGE : String = "TEAM_BADGE"
        const val TEAM_NAME: String = "TEAM_NAME"
        const val TEAM_ID: String = "TEAM_ID"
    }
}