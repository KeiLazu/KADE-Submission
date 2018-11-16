package com.github.footballclubsubmission.data.models

import com.google.gson.annotations.SerializedName

data class PlayerItem(

    @field:SerializedName("strPlayer")
    val strPlayer: String? = null,

    @field:SerializedName("dateBorn")
    val dateBorn: String? = null,

    @field:SerializedName("strNationality")
    val strNationality: String? = null,

    @field:SerializedName("strBanner")
    val strBanner: Any? = null,

    @field:SerializedName("strWeight")
    val strWeight: String? = null,

    @field:SerializedName("idTeam")
    val idTeam: String? = null,

    @field:SerializedName("strDescriptionEN")
    val strDescriptionEN: String? = null,

    @field:SerializedName("strHeight")
    val strHeight: String? = null,

    @field:SerializedName("strPosition")
    val strPosition: String? = null,

    @field:SerializedName("strCutout")
    val strCutout: String? = null,

    @field:SerializedName("strTeam")
    val strTeam: String? = null,

    @field:SerializedName("strTwitter")
    val strTwitter: String? = null,

    @field:SerializedName("strFanart1")
    val strFanart1: String? = null,

    @field:SerializedName("strFanart2")
    val strFanart2: String? = null,

    @field:SerializedName("strFanart3")
    val strFanart3: String? = null,

    @field:SerializedName("strFacebook")
    val strFacebook: String? = null,

    @field:SerializedName("strFanart4")
    val strFanart4: String? = null,

    @field:SerializedName("idPlayer")
    val idPlayer: String? = null,

    @field:SerializedName("strThumb")
    val strThumb: String? = null
)