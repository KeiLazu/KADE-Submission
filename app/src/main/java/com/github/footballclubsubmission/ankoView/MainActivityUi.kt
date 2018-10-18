package com.github.footballclubsubmission.ankoView

import android.support.design.R.attr.colorAccent
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Spinner
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.activities.main.MainActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/18/2018
 *  check https://github.com/KeiLazu for more
 */
class MainActivityUi : AnkoComponent<MainActivity> {

    internal lateinit var listTeam: RecyclerView
    internal lateinit var progressBar: ProgressBar
    internal lateinit var swipeRefresh: SwipeRefreshLayout
    internal lateinit var spinner: Spinner

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            topPadding = dip(dimen(R.dimen.padding_layout))
            leftPadding = dip(dimen(R.dimen.padding_layout))
            rightPadding = dip(dimen(R.dimen.padding_layout))

            spinner = spinner()
            swipeRefresh = swipeRefreshLayout {
                setColorSchemeColors(colorAccent,
                    ContextCompat.getColor(ctx, android.R.color.holo_green_light),
                    ContextCompat.getColor(ctx, android.R.color.holo_orange_light),
                    ContextCompat.getColor(ctx, android.R.color.holo_red_light))

                relativeLayout {
                    lparams(width = matchParent, height = wrapContent)

                    listTeam = recyclerView {
                        lparams(width = matchParent, height = wrapContent)
                        layoutManager = LinearLayoutManager(ctx)
                    }

                    progressBar = progressBar {
                    }.lparams{
                        centerHorizontally()
                    }

                }

            }
        }
    }
}