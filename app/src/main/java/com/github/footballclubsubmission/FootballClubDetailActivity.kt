package com.github.footballclubsubmission

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.view.Gravity
import android.view.View
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class FootballClubDetailActivity : AppCompatActivity() {

    /**
     * I create this to minimize the human error for wrong key in getStringExtra or other things
     */
    companion object {
        const val KEY_MODEL_CLUB = "KEY_MODEL_CLUB"
    }

    private var club: ModelClub? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        DetailActivityUi().setContentView(this)
    }

    private fun initData() {
        val intent = intent
        club = intent.getParcelableExtra<ModelClub>(KEY_MODEL_CLUB)
    }

    // Section: Anko Layout ------------------
    class DetailActivityUi : AnkoComponent<FootballClubDetailActivity> {
        override fun createView(ui: AnkoContext<FootballClubDetailActivity>) = with(ui) {
            verticalLayout {
                gravity = Gravity.CENTER_HORIZONTAL
                padding = dip(16)

                imageView {
                    Picasso.get()
                            .load(ui.owner.club?._clubImage ?: 0)
                            .resize(500, 500).into(this)
                }

                textView {
                    text = ui.owner.club?._clubName ?: "None"
                    gravity = Gravity.CENTER
                }.lparams(width = matchParent) {
                    topMargin = dip(8)
                }

                textView {
                    text = ui.owner.club?._clubDetail ?: "No Detail"
                }.lparams(width = matchParent) {
                    topMargin = dip(16)
                }

            }
        }
    }
    // End Section: Anko Layout --------------

}
