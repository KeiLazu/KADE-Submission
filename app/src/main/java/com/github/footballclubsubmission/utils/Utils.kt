package com.github.footballclubsubmission.utils

import android.view.View

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/18/2018
 *  check https://github.com/KeiLazu for more
 */
class Utils {

    companion object {
        fun View.visible() {
            visibility = View.VISIBLE
        }

        fun View.invisible() {
            visibility = View.INVISIBLE
        }
    }

}