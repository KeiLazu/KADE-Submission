package com.github.footballclubsubmission.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/21/2018
 *  check https://github.com/KeiLazu for more
 */
fun dateConverterToDayShort(dateString: String, datePattern: String): String {
    val format = SimpleDateFormat(datePattern, Locale.ENGLISH)
    val date = format.parse(dateString)
    val output = SimpleDateFormat("EEE", Locale.ENGLISH)
    return output.format(date)
}

fun dateConverterDate(dateString: String, datePattern: String): String {
    val format = SimpleDateFormat(datePattern, Locale.ENGLISH)
    val date = format.parse(dateString)
    val output = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH)
    return output.format(date)
}