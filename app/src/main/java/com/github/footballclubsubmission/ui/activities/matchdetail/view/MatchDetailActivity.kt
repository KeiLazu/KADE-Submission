package com.github.footballclubsubmission.ui.activities.matchdetail.view

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.bumptech.glide.Glide
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.data.db.favoritematch.FavoriteMatchModel
import com.github.footballclubsubmission.data.db.favoritematch.matchDb
import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.data.models.EventsItem
import com.github.footballclubsubmission.data.models.TeamsItem
import com.github.footballclubsubmission.ui.activities.matchdetail.interactor.MatchDetailMvpInteractor
import com.github.footballclubsubmission.ui.activities.matchdetail.presenter.MatchDetailMvpPresenter
import com.github.footballclubsubmission.ui.base.view.BaseActivity
import com.github.footballclubsubmission.utils.dateConverterDate
import com.github.footballclubsubmission.utils.invisible
import com.github.footballclubsubmission.utils.visible
import kotlinx.android.synthetic.main.activity_match_detail.*
import kotlinx.android.synthetic.main.include_match_detail_information.*
import kotlinx.android.synthetic.main.include_match_detail_score.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.select
import javax.inject.Inject

class MatchDetailActivity : BaseActivity(), MatchDetailMvpView {

    companion object {
        const val BUNDLE_KEY_EVENT_ID = "BUNDLE_KEY_EVENT_ID"
        const val DATE_PATTERN = "yyyy-MM-dd"
    }

    private var mMenuItem: Menu? = null
    private var isFavorite: Boolean = false
    private var mEventItem: EventsItem = EventsItem()
    private var mHomeBadge: String? = null
    private var mAwayBadge: String? = null

    @Inject
    internal lateinit var presenter: MatchDetailMvpPresenter<MatchDetailMvpView, MatchDetailMvpInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_detail)
        presenter.onAttach(this)
        initToolbar()
        initGetDataApi()
    }

    private fun initToolbar() {
        match_detail_toolbar.let { it ->
            setSupportActionBar(it)
            supportActionBar?.title = getString(R.string.text_title_match_detail)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.match_detail_menu, menu)
        mMenuItem = menu
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish(); true
            }
            R.id.add_to_fav -> {
                favLogicSwitcher(); true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initGetDataApi() = presenter.getEventDetail(intent.getIntExtra(BUNDLE_KEY_EVENT_ID, 0))

    override fun showProgress() {
        if (match_detail_progress_bar.visibility == View.VISIBLE) hideProgress()
        match_detail_progress_bar.visible()
    }

    override fun hideProgress() = match_detail_progress_bar.invisible()

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun displayEventDetail(eventLeagueResponse: EventLeagueResponse) {
        initWidgets(eventLeagueResponse.events[0])
        initEventData(eventLeagueResponse.events[0])
        isEventFavorited()
        favIconSwitcher()
    }

    private fun initWidgets(eventsItem: EventsItem) {
        putScoreInfo(eventsItem)
        putGoalsInfo(eventsItem)
        putShotsInfo(eventsItem)
        putHomeLineupsInfo(eventsItem)
        putAwayLineupsInfo(eventsItem)
        getBadge(eventsItem.idHomeTeam?.toInt() ?: 0, true)
        getBadge(eventsItem.idAwayTeam?.toInt() ?: 0, false)
    }

    private fun putScoreInfo(eventsItem: EventsItem) {
        include_match_detail_score_tv_home_name.text = eventsItem.strHomeTeam
        include_match_detail_score_tv_away_name.text = eventsItem.strAwayTeam
        include_match_detail_score_home_score.text = eventsItem.intHomeScore
        include_match_detail_score_away_score.text = eventsItem.intAwayScore
        putDateTimeInfo(eventsItem)
    }

    private fun putDateTimeInfo(eventsItem: EventsItem) {
        include_match_detail_score_date_time.text =
                dateConverterDate(eventsItem.dateEvent ?: "", DATE_PATTERN)
    }

    private fun putGoalsInfo(eventsItem: EventsItem) {
        include_match_detail_info_home_scorer.text =
                eventsItem.strHomeGoalDetails; include_match_detail_info_away_scorer.text =
                eventsItem.strAwayGoalDetails
    }

    private fun putShotsInfo(eventsItem: EventsItem) {
        include_match_detail_info_home_total_shot.text =
                eventsItem.intHomeShots; include_match_detail_info_away_total_shots.text = eventsItem.intAwayShots
    }

    private fun putHomeLineupsInfo(eventsItem: EventsItem) {
        include_match_detail_info_home_defense.text = replaceItemLineup(eventsItem.strHomeLineupDefense)
        include_match_detail_info_home_goalkeepers.text = replaceItemLineup(eventsItem.strHomeLineupGoalkeeper)
        include_match_detail_info_home_midfield.text = replaceItemLineup(eventsItem.strHomeLineupMidfield)
        include_match_detail_info_home_forward.text = replaceItemLineup(eventsItem.strHomeLineupForward)
        include_match_detail_info_home_subs.text = replaceItemLineup(eventsItem.strHomeLineupSubstitutes)
    }

    private fun putAwayLineupsInfo(eventsItem: EventsItem) {
        include_match_detail_info_away_defense.text = replaceItemLineup(eventsItem.strAwayLineupDefense)
        include_match_detail_info_away_goalkeepers.text = replaceItemLineup(eventsItem.strAwayLineupGoalkeeper)
        include_match_detail_info_away_midfield.text = replaceItemLineup(eventsItem.strAwayLineupMidfield)
        include_match_detail_info_away_forward.text = replaceItemLineup(eventsItem.strAwayLineupForward)
        include_match_detail_info_away_subs.text = replaceItemLineup(eventsItem.strAwayLineupSubstitutes)
    }

    private fun replaceItemLineup(eventsItemOutput: String?): String? = eventsItemOutput?.replace("; ", ";\n")

    private fun getBadge(teamId: Int, isHomeBadge: Boolean) = presenter.getTeamBadge(teamId, isHomeBadge)

    override fun displayHomeBadge(teamsItem: TeamsItem, isHomeBadge: Boolean) {
        if (isHomeBadge) {
            Glide.with(this).load(teamsItem.strTeamBadge).fitCenter().into(include_match_detail_score_img_home_club)
            mHomeBadge = teamsItem.strTeamBadge
        } else {
            Glide.with(this).load(teamsItem.strTeamBadge).fitCenter().into(include_match_detail_score_img_away_club)
            mAwayBadge = teamsItem.strTeamBadge
        }
    }

    override fun onFragmentAttached() {}
    override fun onFragmentDetached(tag: String) {}

    private fun initEventData(eventsItem: EventsItem) {
        mEventItem = eventsItem
    }

    override fun showMessageAddDb() {
        showMessage(getString(R.string.text_success_add_to_fav))
        isFavorite = true
        favIconSwitcher()
    }

    override fun showMessageRemoveDb() {
        showMessage(getString(R.string.text_success_remove_from_fav))
        isFavorite = false
        favIconSwitcher()
    }

    override fun showMessageError() = showMessage(getString(R.string.text_generic_error))

    private fun isEventFavorited() {
        matchDb.use {
            val result = select(FavoriteMatchModel.TABLE_FAVORITE)
                .whereArgs(
                    "(${FavoriteMatchModel.ID_EVENT} = ${mEventItem.idEvent})"
                ).exec { parseList(classParser<FavoriteMatchModel>()) }
            if (result.isNotEmpty()) isFavorite = true
            Log.i(MatchDetailActivity::class.java.simpleName, "result=$result")
        }
    }

    private fun removeFromFavorite() {
        try {
            matchDb.use {
                delete(
                    FavoriteMatchModel.TABLE_FAVORITE, "(${FavoriteMatchModel.ID_EVENT} = ${mEventItem.idEvent})",
                    FavoriteMatchModel.ID_EVENT to mEventItem.idEvent.toString()
                )
            }
            showMessageRemoveDb()
        } catch (e: SQLiteConstraintException) {
            showMessageError()
        }
    }

    private fun favIconSwitcher() {
        if (isFavorite) mMenuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_star_white_24dp)
        else mMenuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_star_border_white_24dp)
    }

    private fun favLogicSwitcher() {
        if (isFavorite) removeFromFavorite()
        else presenter.addToFav(matchDb, mEventItem, mHomeBadge, mAwayBadge)
    }

}
