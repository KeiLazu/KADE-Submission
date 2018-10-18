package com.github.footballclubsubmission.ankoView

import android.view.Gravity
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.activities.FootballClubDetailActivity
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/18/2018
 *  check https://github.com/KeiLazu for more
 */
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
                text = ui.owner.club?._clubName ?: context.getString(R.string.club_name_null)
                gravity = Gravity.CENTER
            }.lparams(width = matchParent) {
                topMargin = dip(8)
            }

            textView {
                text = ui.owner.club?._clubDetail ?: context.getString(R.string.club_desc_null)
            }.lparams(width = matchParent) {
                topMargin = dip(16)
            }

        }
    }
}