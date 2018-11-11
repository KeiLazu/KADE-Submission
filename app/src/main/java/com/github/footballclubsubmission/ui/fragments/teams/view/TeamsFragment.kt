package com.github.footballclubsubmission.ui.fragments.teams.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.R.array.league
import com.github.footballclubsubmission.data.models.TeamResponse
import com.github.footballclubsubmission.ui.adapters.TeamListAdapter
import com.github.footballclubsubmission.ui.base.view.BaseFragment
import com.github.footballclubsubmission.ui.fragments.teams.interactor.TeamsMvpInteractor
import com.github.footballclubsubmission.ui.fragments.teams.presenter.TeamsMvpPresenter
import com.github.footballclubsubmission.utils.invisible
import com.github.footballclubsubmission.utils.visible
import kotlinx.android.synthetic.main.fragment_teams.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class TeamsFragment : BaseFragment(), TeamsMvpView, OnItemSelectedListener {

    @Inject
    internal lateinit var presenter: TeamsMvpPresenter<TeamsMvpView, TeamsMvpInteractor>
    @Inject
    internal lateinit var mLinearLayoutManager: LinearLayoutManager
    @Inject
    internal lateinit var mTeamListAdapter: TeamListAdapter

    companion object {
        private var instance: TeamsFragment? = null
        fun getInstance(): TeamsFragment {
            if (instance == null) {
                instance = TeamsFragment()
            }
            return instance ?: TeamsFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun setUp() {
        initSpinner()
        initRv()
        presenter.onAttach(this)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    private fun initSpinner() {
        val spinnerItems = resources.getStringArray(league)
        val spinnerAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        teams_spinner.adapter = spinnerAdapter
        teams_spinner.onItemSelectedListener = this
    }

    private fun initRv() {
        mLinearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        teams_rv_teams.let {
            it.layoutManager = mLinearLayoutManager
            it.adapter = mTeamListAdapter
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val leagueName = parent?.selectedItem.toString()
        Log.i("checkLeagueName", "LeagueName = $leagueName")
        presenter.getTeamLeaguesData(leagueName)
    }

    override fun putTeamsData(teamResponse: TeamResponse) {
        mTeamListAdapter.addAllTeam(teamResponse)
    }

    override fun showProgress() = teams_progress_bar.visible()
    override fun hideProgress() = teams_progress_bar.invisible()
}
