package com.github.footballclubsubmission.ui.activities.playerdetail.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.github.footballclubsubmission.R
import kotlinx.android.synthetic.main.activity_player_detail.*

class PlayerDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_KEY_IMG_FANART = "EXTRA_KEY_IMG_FANART"
        const val EXTRA_KEY_PLAYER_NAME = "EXTRA_KEY_PLAYER_NAME"
        const val EXTRA_KEY_PLAYER_HEIGHT = "EXTRA_KEY_PLAYER_HEIGHT"
        const val EXTRA_KEY_PLAYER_WEIGHT = "EXTRA_KEY_PLAYER_WEIGHT"
        const val EXTRA_KEY_PLAYER_DESCRIPTION = "EXTRA_KEY_PLAYER_DESCRIPTION"
        const val EXTRA_KEY_PLAYER_POSITION = "EXTRA_KEY_PLAYER_POSITION"

        fun newInstance(
            ctx: Context, imgFanart: String?, playerName: String?,
            playerHeight: String?, playerWeight: String?, playerDescription: String?, playerPosition: String?
        ): Intent {
            val intent = Intent(ctx, PlayerDetailActivity::class.java)
            intent.putExtra(EXTRA_KEY_IMG_FANART, imgFanart).putExtra(EXTRA_KEY_PLAYER_NAME, playerName)
                .putExtra(EXTRA_KEY_PLAYER_HEIGHT, playerHeight).putExtra(EXTRA_KEY_PLAYER_WEIGHT, playerWeight)
                .putExtra(EXTRA_KEY_PLAYER_DESCRIPTION, playerDescription).putExtra(EXTRA_KEY_PLAYER_POSITION, playerPosition)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_detail)
        initWidgets()
    }

    private fun initWidgets() {
        Glide.with(this).load(intent.extras.getString(EXTRA_KEY_IMG_FANART, ""))
            .fitCenter().error(R.drawable.ic_launcher_background).into(player_detail_img_fanart)
        player_detail_tv_height_output.text = intent.extras.getString(EXTRA_KEY_PLAYER_HEIGHT, "")
        player_detail_tv_weight_output.text = intent.extras.getString(EXTRA_KEY_PLAYER_WEIGHT, "")
        player_detail_tv_name_output.text = intent.extras.getString(EXTRA_KEY_PLAYER_NAME, "")
        player_detail_tv_player_description_output.text = intent.extras.getString(EXTRA_KEY_PLAYER_DESCRIPTION, "")
        player_detail_tv_position_output.text = intent.extras.getString(EXTRA_KEY_PLAYER_POSITION, "")

    }

}
