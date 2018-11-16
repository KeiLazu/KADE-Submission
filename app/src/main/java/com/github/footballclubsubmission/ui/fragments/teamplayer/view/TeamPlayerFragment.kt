package com.github.footballclubsubmission.ui.fragments.teamplayer.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.data.models.PlayerListResponse
import com.github.footballclubsubmission.ui.adapters.PlayerListAdapter
import com.github.footballclubsubmission.ui.base.view.BaseFragment
import com.github.footballclubsubmission.ui.fragments.teamplayer.interactor.TeamPlayerMvpInteractor
import com.github.footballclubsubmission.ui.fragments.teamplayer.presenter.TeamPlayerMvpPresenter
import kotlinx.android.synthetic.main.fragment_team_player.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class TeamPlayerFragment : BaseFragment(), TeamPlayerMvpView {

    @Inject
    internal lateinit var presenter: TeamPlayerMvpPresenter<TeamPlayerMvpView, TeamPlayerMvpInteractor>
    @Inject
    internal lateinit var mLinearLayoutManager: LinearLayoutManager
    @Inject
    internal lateinit var mPlayerListAdapter: PlayerListAdapter

    companion object {
        const val BUNDLE_KEY_TEAM_ID = "BUNDLE_KEY_TEAM_ID"

        fun newInstance(teamId: Int): Fragment {
            val fragment = TeamPlayerFragment()
            val bundle = Bundle()
            bundle.putInt(BUNDLE_KEY_TEAM_ID, teamId)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
    // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragment_team_player, container, false)

    override fun setUp() {
        presenter.onAttach(this)
        initWidgets()
        presenter.getPlayerListData(arguments?.getInt(BUNDLE_KEY_TEAM_ID, 0) ?: 0)
    }

    override fun onDetach() {
        presenter.onDetach()
        super.onDetach()
    }

    private fun initWidgets() {
        mLinearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        team_player_rv_player_list.let {
            it.layoutManager = mLinearLayoutManager
            it.adapter = mPlayerListAdapter
        }
    }

    override fun putPlayerListData(playerListResponse: PlayerListResponse) {
        mPlayerListAdapter.addPlayerListData(playerListResponse)
        mPlayerListAdapter.notifyDataSetChanged()
    }
}
