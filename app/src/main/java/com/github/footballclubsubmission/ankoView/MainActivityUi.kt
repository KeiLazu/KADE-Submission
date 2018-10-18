package com.github.footballclubsubmission.ankoView

import android.support.v7.widget.LinearLayoutManager
import com.github.footballclubsubmission.activities.FootballClubDetailActivity
import com.github.footballclubsubmission.activities.MainActivity
import com.github.footballclubsubmission.adapters.ClubAdapter
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.verticalLayout

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/18/2018
 *  check https://github.com/KeiLazu for more
 */
class MainActivityUi : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            recyclerView {
                layoutManager = LinearLayoutManager(context)
                adapter = ClubAdapter(context, ui.owner.clubList) {
                    startActivity<FootballClubDetailActivity>(
                        FootballClubDetailActivity.KEY_MODEL_CLUB to it
                    )
                }
            }
        }
    }
}