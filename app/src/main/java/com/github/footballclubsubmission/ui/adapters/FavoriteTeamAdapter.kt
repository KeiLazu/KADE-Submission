package com.github.footballclubsubmission.ui.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.data.db.favoritematch.FavoriteTeamModel
import com.github.footballclubsubmission.ui.activities.teamdetail.view.TeamDetailActivity
import kotlinx.android.synthetic.main.list_item_team.view.*

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/17/2018
 *  check https://github.com/KeiLazu for more
 */
class FavoriteTeamAdapter(private val response: MutableList<FavoriteTeamModel>) : RecyclerView.Adapter<FavoriteTeamAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item_team, parent, false)
    )

    override fun getItemCount(): Int = response.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.clear()
        holder.bind(response[position])
    }

    fun addAllTeam(result: List<FavoriteTeamModel>) {
        response.addAll(result.toMutableList())
        notifyDataSetChanged()
    }


    inner class ViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
        fun clear() : Unit = itemView.list_item_team_tv_team_name.let { it.text = "" }

        fun bind(favoriteTeamModel: FavoriteTeamModel) {
            itemView.list_item_team_tv_team_name.text = favoriteTeamModel.teamName
            Glide.with(itemView.context).load(favoriteTeamModel.teamBadge).fitCenter()
                .error(R.drawable.ic_launcher_background).into(itemView.list_item_team_img_badge)
            itemView.setOnClickListener{
                val intent = TeamDetailActivity.newInstance(itemView.context, favoriteTeamModel.teamId?.toInt())
                itemView.context.startActivity(intent)
            }
        }

    }
}