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
import kotlinx.android.synthetic.main.list_item_match_list.view.*

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
class LastMatchListAdapter(private val response: EventLeagueResponse) :
    RecyclerView.Adapter<LastMatchListAdapter.LastMatchViewHolder>() {

    lateinit var openLastMatchDetailActivity: OpenLastMatchDetailActivity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastMatchViewHolder =
        LastMatchViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_match_list, parent, false
            )
        )

    override fun getItemCount(): Int = this.response.events.size

    override fun onBindViewHolder(holderLastMatch: LastMatchViewHolder, position: Int) {
        holderLastMatch.let {
            it.clear()
            it.bind(position)
        }
    }

    internal fun addMatchList(eventsItems: MutableList<EventsItem>) {
        this.response.events.addAll(eventsItems)
        notifyDataSetChanged()
    }

    internal fun setMatchListInterface(openLastMatchDetailActivity: OpenLastMatchDetailActivity) {
        this.openLastMatchDetailActivity = openLastMatchDetailActivity
    }

    inner class LastMatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {
            itemView.list_item_match_list_date_time.text = ""
            itemView.list_item_match_list_home_name_club.text = ""
            itemView.list_item_match_list_away_name_club.text = ""
            itemView.list_item_match_list_home_score.text = "0"
            itemView.list_item_match_list_away_score.text = "0"
        }

        private fun getIndividualData(position: Int): EventsItem? {
            return response.events[position]
        }

        fun bind(position: Int) {
            inflateData(
                getIndividualData(position)?.dateEvent,
                getIndividualData(position)?.strHomeTeam,
                getIndividualData(position)?.strAwayTeam,
                getIndividualData(position)?.intHomeScore,
                getIndividualData(position)?.intAwayScore
            )
            setItemClickListener(position)
        }

        private fun setItemClickListener(position: Int) {
            itemView.setOnClickListener {
                openLastMatchDetailActivity.openLastMatchDetailActivity(getIndividualData(position)?.idEvent ?: 0)
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

    interface OpenLastMatchDetailActivity {
        fun openLastMatchDetailActivity(eventId: Int)
    }

}