package com.github.footballclubsubmission.ui.fragments.teamplayer.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.ui.base.view.BaseFragment
import com.github.footballclubsubmission.ui.fragments.teamplayer.interactor.TeamPlayerMvpInteractor
import com.github.footballclubsubmission.ui.fragments.teamplayer.presenter.TeamPlayerMvpPresenter
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class TeamPlayerFragment : BaseFragment(), TeamPlayerMvpView {

    companion object {
        const val BUNDLE_KEY_TEAM_ID = "BUNDLE_KEY_TEAM_ID"

        private var instance : TeamPlayerFragment? = null
        fun newInstance(teamId: Int) : TeamPlayerFragment {
            if (instance == null)
                instance = TeamPlayerFragment()
            val bundle = Bundle()
            bundle.putInt(BUNDLE_KEY_TEAM_ID, teamId)
            instance?.arguments = bundle
            return instance ?: TeamPlayerFragment()
        }
    }

    @Inject
    lateinit var presenter: TeamPlayerMvpPresenter<TeamPlayerMvpView, TeamPlayerMvpInteractor>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
    // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragment_team_player, container, false)

    override fun setUp() {}

}
