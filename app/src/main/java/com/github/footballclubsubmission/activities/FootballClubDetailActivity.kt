package com.github.footballclubsubmission.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.ankoView.DetailActivityUi
import com.github.footballclubsubmission.data.models.ModelClub
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class FootballClubDetailActivity : AppCompatActivity() {

    /**
     * I create this to minimize the human error for wrong key in getStringExtra or other things
     */
    companion object {
        const val KEY_MODEL_CLUB = "KEY_MODEL_CLUB"
    }

    internal var club: ModelClub? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
        DetailActivityUi().setContentView(this)
    }

    private fun initData() {
        val intent = intent
        club = intent.getParcelableExtra(KEY_MODEL_CLUB)
    }

}
