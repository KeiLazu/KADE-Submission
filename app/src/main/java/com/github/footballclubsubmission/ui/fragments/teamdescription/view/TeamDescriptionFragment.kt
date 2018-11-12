package com.github.footballclubsubmission.ui.fragments.teamdescription.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.data.models.TeamsItem
import com.github.footballclubsubmission.ui.base.view.BaseFragment
import com.github.footballclubsubmission.ui.fragments.teamdescription.interactor.TeamDescriptionMvpInteractor
import com.github.footballclubsubmission.ui.fragments.teamdescription.presenter.TeamDescriptionMvpPresenter
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class TeamDescriptionFragment : BaseFragment(), TeamDescriptionMvpView {

    companion object {
        private const val BUNDLE_KEY_STADIUM_NAME = "BUNDLE_KEY_STADIUM_NAME"
        private const val BUNDLE_KEY_STADIUM_DESC = "BUNDLE_KEY_STADIUM_DESC"
        private const val BUNDLE_KEY_STADIUM_THUMB = "BUNDLE_KEY_STADIUM_THUMB"
        private const val BUNDLE_KEY_DESCRIPTION_EN = "BUNDLE_KEY_DESCRIPTION_EN"

        private var instance : TeamDescriptionFragment? = null
        fun newInstance(stadiumName: String?, stadiumThumb: String?, stadiumDesc: String?, DescEn: String?) : TeamDescriptionFragment {
            if (instance == null)
                instance = TeamDescriptionFragment()
            val bundle = Bundle()
            bundle.let {
                it.putString(BUNDLE_KEY_STADIUM_NAME, stadiumName)
                it.putString(BUNDLE_KEY_STADIUM_THUMB, stadiumThumb)
                it.putString(BUNDLE_KEY_STADIUM_DESC, stadiumDesc)
                it.putString(BUNDLE_KEY_DESCRIPTION_EN, DescEn)
                instance?.arguments = it
            }
            return instance ?: TeamDescriptionFragment()
        }
    }

    @Inject
    internal lateinit var presenter: TeamDescriptionMvpPresenter<TeamDescriptionMvpView, TeamDescriptionMvpInteractor>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_description, container, false)
    }

    override fun setUp() {}

}
