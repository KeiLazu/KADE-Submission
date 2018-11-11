package com.github.footballclubsubmission.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.data.models.EventsItem
import com.github.footballclubsubmission.ui.activities.matchdetail.view.MatchDetailActivity
import com.github.footballclubsubmission.utils.dateConverterDate
import kotlinx.android.synthetic.main.list_item_next_match_list.view.*

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/10/2018
 *  check https://github.com/KeiLazu for more
 */
class NextMatchListAdapter(private val response: EventLeagueResponse) :
    RecyclerView.Adapter<NextMatchListAdapter.NextMatchViewHolder>() {

    var mNextMatchListCallback: NextMatchListCallback? = null

    fun addAllData(eventLeagueResponse: EventLeagueResponse) {
        eventLeagueResponse.let { response.events.addAll(it.events) }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextMatchViewHolder =
        NextMatchViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_next_match_list,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = response.events.size

    override fun onBindViewHolder(holder: NextMatchViewHolder, position: Int) {
        holder.clear()
        holder.bind(response.events[position])
    }

    inner class NextMatchViewHolder(view: View?) : RecyclerView.ViewHolder(view) {

        fun clear() {
            itemView.list_item_next_match_list_date_time.text = ""
            itemView.list_item_next_match_list_home_name_club.text = ""
            itemView.list_item_next_match_list_away_name_club.text = ""
            itemView.list_item_next_match_list_home_score.text = "0"
            itemView.list_item_next_match_list_away_score.text = "0"
        }

        fun bind(eventsItem: EventsItem) {
            itemView.let {
                it.list_item_next_match_list_date_time.text = dateConverterDate(eventsItem.dateEvent ?: "", MatchDetailActivity.DATE_PATTERN)
                it.list_item_next_match_list_home_name_club.text = eventsItem.strHomeTeam
                it.list_item_next_match_list_away_name_club.text = eventsItem.strAwayTeam
                it.list_item_next_match_list_home_score.text = eventsItem.intHomeScore
                it.list_item_next_match_list_away_score.text = eventsItem.intAwayScore
                it.list_item_next_match_list_notification.isClickable = true
                it.list_item_next_match_list_notification.setOnClickListener{mNextMatchListCallback?.openCalendarForNotification()}
                it.setOnClickListener{mNextMatchListCallback?.openNextMatchDetailActivity(eventsItem.idEvent ?: 0)}
            }
        }
    }

    interface NextMatchListCallback {
        fun openCalendarForNotification()
        fun openNextMatchDetailActivity(eventId: Int?)
    }

}