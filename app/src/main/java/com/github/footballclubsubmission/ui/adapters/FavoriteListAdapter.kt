package com.github.footballclubsubmission.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.data.db.favoritematch.FavoriteMatchModel
import com.github.footballclubsubmission.ui.activities.matchdetail.view.MatchDetailActivity
import com.github.footballclubsubmission.utils.dateConverterDate
import kotlinx.android.synthetic.main.list_item_match_list.view.*
import org.jetbrains.anko.startActivity

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/28/2018
 *  check https://github.com/KeiLazu for more
 */
class FavoriteListAdapter(private val response: MutableList<FavoriteMatchModel>) :
    RecyclerView.Adapter<FavoriteListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_match_list, parent, false
        )
    )

    override fun getItemCount(): Int = response.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.clear()
        holder.bind(position)
        holder.setItemClickListener(response[position].idEvent)
    }

    internal fun addFavList(eventsItems: MutableList<FavoriteMatchModel>) {
        response.clear()
        this.response.addAll(eventsItems)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun clear() {
            itemView.list_item_match_list_date_time.text = ""
            itemView.list_item_match_list_home_name_club.text = ""
            itemView.list_item_match_list_away_name_club.text = ""
            itemView.list_item_match_list_home_score.text = "0"
            itemView.list_item_match_list_away_score.text = "0"
        }

        private fun getIndividualData(position: Int): FavoriteMatchModel? {
            return response[position]
        }

        fun bind(position: Int) {
            inflateData(
                getIndividualData(position)?.dateEvent,
                getIndividualData(position)?.strHomeTeam,
                getIndividualData(position)?.strAwayTeam,
                getIndividualData(position)?.intHomeScore,
                getIndividualData(position)?.intAwayScore.toString()
            )
        }

        fun setItemClickListener(eventId: Int?) {
            itemView.setOnClickListener {
                itemView.context.startActivity<MatchDetailActivity>(MatchDetailActivity.BUNDLE_KEY_EVENT_ID to eventId)
            }
        }

        private fun inflateData(
            datetime: String?,
            nameHomeClub: String?,
            nameAwayClub: String?,
            scoreHome: String?,
            scoreAway: String?
        ) {
            datetime?.let {
                itemView.list_item_match_list_date_time.text =
                        dateConverterDate(datetime, MatchDetailActivity.DATE_PATTERN)
            }
            nameHomeClub?.let { itemView.list_item_match_list_home_name_club.text = it }
            nameAwayClub?.let { itemView.list_item_match_list_away_name_club.text = it }
            scoreHome?.let { itemView.list_item_match_list_home_score.text = it }
            scoreAway?.let { itemView.list_item_match_list_away_score.text = it }
        }
    }
}