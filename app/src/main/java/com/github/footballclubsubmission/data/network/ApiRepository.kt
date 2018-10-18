package com.github.footballclubsubmission.data.network

import java.net.URL

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/18/2018
 *  check https://github.com/KeiLazu for more
 */
class ApiRepository {

    fun doRequest(_url: String): String {
        return URL(_url).readText()
    }
}