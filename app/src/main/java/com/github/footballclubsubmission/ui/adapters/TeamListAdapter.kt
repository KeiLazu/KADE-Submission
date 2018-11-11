package com.github.footballclubsubmission.ui.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.data.models.TeamsItem
import com.github.footballclubsubmission.ui.activities.teamdetail.view.TeamDetailActivity
import kotlinx.android.synthetic.main.list_item_team.view.*

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/10/2018
 *  check https://github.com/KeiLazu for more
 */
class TeamListAdapter(private val response: TeamResponse) : RecyclerView.Adapter<TeamListAdapter.ViewHolder>() {

    fun addAllTeam(teamResponse: TeamResponse) {
        response.teams.clear()
        teamResponse.let { response.teams.addAll(it.teams) }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item_team, parent, false)
    )

    override fun getItemCount(): Int = response.teams.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.clear()
        holder.bind(response.teams[position])
    }

    class ViewHolder(view: View?) : RecyclerView.ViewHolder(view), View.OnClickListener {

        fun clear() {
            itemView.list_item_team_tv_team_name.text = ""
        }

        fun bind(teamsItem: TeamsItem) {
            itemView.list_item_team_img_badge.let {
                Glide.with(itemView.context).load(teamsItem.strTeamBadge)
                    .fitCenter()
                    .error(R.drawable.ic_launcher_background)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(it)
            }
            itemView.list_item_team_tv_team_name.text = teamsItem.strTeam
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val intent = Intent(itemView.context, TeamDetailActivity::class.java)
            itemView.context.startActivity(intent)
        }
    }

}