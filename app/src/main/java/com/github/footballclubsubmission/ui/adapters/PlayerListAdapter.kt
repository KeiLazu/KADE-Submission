package com.github.footballclubsubmission.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.data.models.PlayerItem
import com.github.footballclubsubmission.data.models.PlayerListResponse
import com.github.footballclubsubmission.ui.activities.playerdetail.view.PlayerDetailActivity
import kotlinx.android.synthetic.main.list_item_player.view.*

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/15/2018
 *  check https://github.com/KeiLazu for more
 */
class PlayerListAdapter(private val response: PlayerListResponse) :
    RecyclerView.Adapter<PlayerListAdapter.ViewHolder>() {

    fun addPlayerListData(playerListResponse: PlayerListResponse) {
        playerListResponse.let { response.player.addAll(it.player) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_player, parent, false))

    override fun getItemCount(): Int = response.player.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.clear()
        holder.bind(response.player[position])
    }

    inner class ViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
        fun clear() {
            itemView.list_item_player_tv_name.text = ""
            itemView.list_item_player_tv_position.text = ""
        }

        fun bind(playerItem: PlayerItem) {
            Glide.with(itemView.context).load(playerItem.strCutout).fitCenter()
                .into(itemView.list_item_player_img_cutoff)
            itemView.list_item_player_tv_name.text = playerItem.strPlayer
            itemView.list_item_player_tv_position.text = playerItem.strPosition
            itemView.isClickable = true
            itemView.setOnClickListener {
                itemView.context.startActivity(
                    PlayerDetailActivity.newInstance(
                        itemView.context, playerItem.strFanart1,
                        playerItem.strPlayer, playerItem.strHeight, playerItem.strWeight, playerItem.strDescriptionEN,
                        playerItem.strPosition
                    )
                )
            }
        }

    }
}