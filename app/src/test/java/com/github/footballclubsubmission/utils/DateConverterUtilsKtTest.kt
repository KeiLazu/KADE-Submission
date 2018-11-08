package com.github.footballclubsubmission.utils

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Kei Lazu (Kennix Lazuardi) on 10/30/2018
 * check https://github.com/KeiLazu for more
 */
class DateConverterUtilsKtTest {

    @Test
    fun dateConverterDateSuccess() {
        assertEquals(
            "Wed, 28 Feb 2018",
            com.github.footballclubsubmission.utils.dateConverterDate("02/28/2018", "MM/dd/yyyy")
        )
    }
}