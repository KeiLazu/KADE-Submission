package com.github.footballclubsubmission

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private var clubList: MutableList<ModelClub> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRv()
        MainActivityUi().setContentView(this)
    }

    private fun initRv() {
        val clubName = resources.getStringArray(R.array.club_name)
        val clubImage = resources.obtainTypedArray(R.array.club_image)
        val clubDetail = resources.getStringArray(R.array.club_detail)
        clubList.clear()
        for (i in clubName.indices) {
            clubList.add(
                    ModelClub(clubName[i], clubImage.getResourceId(i, 0), clubDetail[i])
            )
        }
    }

    // Section: Anko Layout ------------------
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
    // End Section: Anko Layout --------------

}
