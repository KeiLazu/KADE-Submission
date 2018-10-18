package com.github.footballclubsubmission.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.github.footballclubsubmission.adapters.ClubAdapter
import com.github.footballclubsubmission.data.models.ModelClub
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.ankoView.MainActivityUi
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    internal var clubList: MutableList<ModelClub> = mutableListOf()

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
                ModelClub(
                    clubName[i],
                    clubImage.getResourceId(i, 0),
                    clubDetail[i]
                )
            )
        }
    }

}
