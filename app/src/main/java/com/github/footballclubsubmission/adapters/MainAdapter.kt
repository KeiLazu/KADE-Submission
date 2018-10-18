package com.github.footballclubsubmission.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.data.models.Team
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/18/2018
 *  check https://github.com/KeiLazu for more
 */
class MainAdapter (private val teams: List<Team>)
    : RecyclerView.Adapter<TeamViewHolder>() {

    override fun onCreateViewHolder(_parent: ViewGroup, _viewType: Int): TeamViewHolder {
        return TeamViewHolder(TeamUi().createView(AnkoContext.Companion.create(_parent.context, _parent)))
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(_holder: TeamViewHolder, _position: Int) {
        _holder.bindItem(teams[_position])
    }

}

class TeamUi : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout() {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(dimen(R.dimen.padding_layout))
                orientation = LinearLayout.HORIZONTAL

                imageView {
                    id = R.id.team_badge
                }.lparams {
                    height = dip(dimen(R.dimen.img_height))
                    width = dip(dimen(R.dimen.img_width))
                }

                textView {
                    id = R.id.team_name
                    textSize = 16f
                }.lparams{
                    margin = dip(dimen(R.dimen.margin_team_name))
                }
            }
        }
    }
}

class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val teamBadge: ImageView = view.find(R.id.team_badge)
    private val teamName: TextView = view.find(R.id.team_name)

    fun bindItem(teams: Team) {
        Picasso.get().load(teams.teamBadge).into(teamBadge)
        teamName.text = teams.teamName
    }
}
