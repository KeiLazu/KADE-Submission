package com.github.footballclubsubmission.ui.activities.teamdetail.view

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.data.db.favoritematch.FavoriteTeamModel
import com.github.footballclubsubmission.data.db.favoritematch.teamDb
import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.ui.activities.teamdetail.interactor.TeamDetailMvpInteractor
import com.github.footballclubsubmission.ui.activities.teamdetail.presenter.TeamDetailMvpPresenter
import com.github.footballclubsubmission.ui.adapters.TeamDetailPagerAdapter
import com.github.footballclubsubmission.ui.base.view.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_team_detail.*
import kotlinx.android.synthetic.main.include_collapsable_team_detail.*
import org.jetbrains.anko.db.delete
import javax.inject.Inject

class TeamDetailActivity : BaseActivity(), TeamDetailMvpView, HasSupportFragmentInjector,
    TabLayout.OnTabSelectedListener {

    companion object {
        const val EXTRA_TEAM_ID = "EXTRA_TEAM_ID"
        fun newInstance(context: Context, teamId: Int?): Intent =
            Intent(context, TeamDetailActivity::class.java).putExtra(EXTRA_TEAM_ID, teamId ?: 0)
    }

    @Inject
    internal lateinit var presenter: TeamDetailMvpPresenter<TeamDetailMvpView, TeamDetailMvpInteractor>
    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    private lateinit var teamDetailPagerAdapter: TeamDetailPagerAdapter

    private var isFavorite: Boolean = false
    private lateinit var mTeamResponse: TeamResponse

    private var mMenuItem: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)
        presenter.onAttach(this)
        presenter.getTeamDetailData(intent.getIntExtra(EXTRA_TEAM_ID, 0))
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector
    override fun onFragmentAttached() {}
    override fun onFragmentDetached(tag: String) {}

    override fun onTabReselected(tab: TabLayout.Tab?) {}
    override fun onTabUnselected(tab: TabLayout.Tab?) {}
    override fun onTabSelected(tab: TabLayout.Tab?) =
        include_content_team_detail_view_pager.let { it.currentItem = tab?.position ?: 0 }

    private fun initPagerAdapter(teamResponse: TeamResponse) {
        mTeamResponse = teamResponse
        team_detail_nsv.isFillViewport = true
        teamDetailPagerAdapter = TeamDetailPagerAdapter(supportFragmentManager, teamResponse.teams.first())
        teamDetailPagerAdapter.notifyDataSetChanged()
        team_detail_tab_layout.let {
            it.addTab(it.newTab().setText(getString(R.string.text_overview_team)))
            it.addTab(it.newTab().setText(getString(R.string.text_player_detail)))
            it.addOnTabSelectedListener(this)
        }
        include_content_team_detail_view_pager.let {
            it.adapter = teamDetailPagerAdapter; it.offscreenPageLimit = teamDetailPagerAdapter.count
            it.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(team_detail_tab_layout))
        }
    }

    private fun initWidgets(teamResponse: TeamResponse) {
        teamResponse.teams.first().let {
            include_collapsable_team_detail_tv_year.text = it.intFormedYear.toString()
            include_collapsable_team_detail_tv_manager.text = it.strManager
            Glide.with(this).load(it.strTeamBadge).fitCenter().into(include_collapsable_team_detail_img_badge)
        }
    }

    private fun initToolbar(teamResponse: TeamResponse) {
        teamResponse.teams.first().let {
            team_detail_layout_collapsing_toolbar.isTitleEnabled = true
            team_detail_layout_collapsing_toolbar.title = it.strTeam
            team_detail_nsv.isNestedScrollingEnabled = false
        }

        collapsable_team_detail_toolbar.let { it ->
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

    private fun favLogicSwitcher() {
        if (isFavorite) removeFromFavorite()
        else presenter.addToFav(teamDb, mTeamResponse.teams.first())
    }

    private fun removeFromFavorite() {
        try {
            teamDb.use {
                delete(
                    FavoriteTeamModel.TABLE_FAV_TEAM,
                    "(${FavoriteTeamModel.TEAM_ID} = ${mTeamResponse.teams.first().idTeam})",
                    FavoriteTeamModel.TEAM_ID to (mTeamResponse.teams.first().idTeam ?: 0)
                )
            }
            showMessageRemoveDb()
        } catch (e: SQLiteConstraintException) {
            showMessageError()
        }
    }

    override fun showMessageError() = showMessage(getString(R.string.text_generic_error))

    override fun displayTeamData(teamResponse: TeamResponse) {
        teamResponse.let {
            initWidgets(it)
            initPagerAdapter(it)
            initToolbar(it)
        }
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

    private fun favIconSwitcher() {
        if (isFavorite) mMenuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_star_white_24dp)
        else mMenuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_star_border_white_24dp)
    }

}
