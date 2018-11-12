package com.github.footballclubsubmission.ui.activities.teamdetail.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.ui.activities.teamdetail.interactor.TeamDetailMvpInteractor
import com.github.footballclubsubmission.ui.activities.teamdetail.presenter.TeamDetailMvpPresenter
import com.github.footballclubsubmission.ui.adapters.TeamDetailPagerAdapter
import com.github.footballclubsubmission.ui.base.view.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_team_detail.*
import kotlinx.android.synthetic.main.include_content_team_detail.*
import javax.inject.Inject

class TeamDetailActivity : BaseActivity(), TeamDetailMvpView, HasSupportFragmentInjector,
    TabLayout.OnTabSelectedListener {

    companion object {
        private const val EXTRA_TEAM_ID = "EXTRA_TEAM_ID"
        fun newInstance(context: Context, teamId: Int?): Intent =
            Intent(context, TeamDetailActivity::class.java).putExtra(EXTRA_TEAM_ID, teamId ?: 0)
    }

    @Inject
    internal lateinit var presenter: TeamDetailMvpPresenter<TeamDetailMvpView, TeamDetailMvpInteractor>
    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    private lateinit var teamDetailPagerAdapter: TeamDetailPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)
        presenter.onAttach(this)
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
    override fun onTabSelected(tab: TabLayout.Tab?) = include_content_team_detail_view_pager.let { it.currentItem = tab?.position ?: 0 }

    private fun initPagerAdapter(teamResponse: TeamResponse) {
        teamDetailPagerAdapter = TeamDetailPagerAdapter(supportFragmentManager, teamResponse.teams.first())
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

    override fun displayTeamData(teamResponse: TeamResponse) {
        initPagerAdapter(teamResponse)
    }

}
