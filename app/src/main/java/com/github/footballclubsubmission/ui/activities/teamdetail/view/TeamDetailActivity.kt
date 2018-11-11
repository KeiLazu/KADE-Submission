package com.github.footballclubsubmission.ui.activities.teamdetail.view

import android.os.Bundle
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.ui.activities.teamdetail.interactor.TeamDetailMvpInteractor
import com.github.footballclubsubmission.ui.activities.teamdetail.presenter.TeamDetailMvpPresenter
import com.github.footballclubsubmission.ui.base.view.BaseActivity
import javax.inject.Inject

class TeamDetailActivity : BaseActivity(), TeamDetailMvpView {

    @Inject
    internal lateinit var presenter: TeamDetailMvpPresenter<TeamDetailMvpView, TeamDetailMvpInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)
        presenter.onAttach(this)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onFragmentAttached() {}
    override fun onFragmentDetached(tag: String) {}
}
