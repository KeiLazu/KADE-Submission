package com.github.footballclubsubmission.data.models

import com.google.gson.annotations.SerializedName

data class PlayerListResponse(

    @field:SerializedName("player")
    var player: MutableList<PlayerItem>
)