package com.github.footballclubsubmission

import android.os.Parcelable
import android.support.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/16/2018
 *  check https://github.com/KeiLazu for more
 */
@Parcelize
data class ModelClub(val _clubName: String?, val _clubImage: Int?, val _clubDetail: String?): Parcelable