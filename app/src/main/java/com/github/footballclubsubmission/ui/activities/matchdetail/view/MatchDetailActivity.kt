package com.github.footballclubsubmission.ui.activities.matchdetail.view

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.github.footballclubsubmission.R
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
import javax.inject.Inject

class MatchDetailActivity : BaseActivity(), MatchDetailMvpView {

    companion object {
        const val BUNDLE_KEY_EVENT_ID = "BUNDLE_KEY_EVENT_ID"
        const val DATE_PATTERN = "yyyy-MM-dd"
    }

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
            it.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }

    private fun initGetDataApi() {
        presenter.onViewCreated(intent.getIntExtra(BUNDLE_KEY_EVENT_ID, 0))
    }

    override fun showProgress() {
        if (match_detail_progress_bar.visibility == View.VISIBLE) hideProgress()
        match_detail_progress_bar.visible()
    }

    override fun hideProgress() {
        match_detail_progress_bar.invisible()
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun displayEventDetail(eventsItem: EventsItem) {
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

    private fun replaceItemLineup(eventsItemOutput: String?): String? {
        return eventsItemOutput?.replace("; ", ";\n")
    }

    private fun getBadge(teamId: Int, isHomeBadge: Boolean) {
        presenter.getTeamBadge(teamId, isHomeBadge)
    }

    override fun displayHomeBadge(teamsItem: TeamsItem, isHomeBadge: Boolean) {
        if (isHomeBadge) Glide.with(this).load(teamsItem.strTeamBadge).fitCenter().into(
            include_match_detail_score_img_home_club
        )
        else Glide.with(this).load(teamsItem.strTeamBadge).fitCenter().into(include_match_detail_score_img_away_club)
    }

    override fun onFragmentAttached() {}
    override fun onFragmentDetached(tag: String) {}

}
