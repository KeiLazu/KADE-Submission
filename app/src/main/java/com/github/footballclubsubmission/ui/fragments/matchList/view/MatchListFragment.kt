package com.github.footballclubsubmission.ui.fragments.matchList.view


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.ui.activities.matchDetail.view.MatchDetailActivity
import com.github.footballclubsubmission.ui.adapters.MatchListAdapter
import com.github.footballclubsubmission.ui.base.view.BaseFragment
import com.github.footballclubsubmission.ui.fragments.matchList.interactor.MatchListMvpInteractor
import com.github.footballclubsubmission.ui.fragments.matchList.presenter.MatchListMvpPresenter
import kotlinx.android.synthetic.main.fragment_match_list.*
import javax.inject.Inject
import com.github.footballclubsubmission.utils.visible
import com.github.footballclubsubmission.utils.invisible

/**
 * A simple [Fragment] subclass.
 *
 */
class MatchListFragment : BaseFragment(), MatchListMvpView, MatchListAdapter.OpenMatchDetailActivity {

    @Inject
    internal lateinit var presenter: MatchListMvpPresenter<MatchListMvpView, MatchListMvpInteractor>
    @Inject
    internal lateinit var mLayoutManager: LinearLayoutManager
    @Inject
    internal lateinit var mMatchListAdapter: MatchListAdapter

    companion object {
        const val DISPLAY_MODE_NEXT_MATCH: Int = 1
        const val DISPLAY_MODE_LAST_MATCH: Int = 2

        private const val BUNDLE_KEY_DISPLAY_MODE: String = "BUNDLE_KEY_DISPLAY_MODE"
        fun newInstance(displayMode: Int): MatchListFragment {
            val fragment = MatchListFragment()
            val bundle = Bundle()
            bundle.putInt(BUNDLE_KEY_DISPLAY_MODE, displayMode)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_match_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() = getMode()

    override fun onDetach() {
        presenter.onDetach()
        super.onDetach()
    }

    private fun getMode() {
        if (arguments?.isEmpty != true) {
            var displayMode: Int = arguments?.getInt(BUNDLE_KEY_DISPLAY_MODE) ?: 0
            configMatchList(displayMode)
        }
    }

    private fun configMatchList(displayMode: Int) {
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        match_list_rv_match.apply {
            layoutManager = mLayoutManager; itemAnimator = DefaultItemAnimator(); adapter = mMatchListAdapter
        }
        mMatchListAdapter.setMatchListInterface(this)
        presenter.onViewPrepared(displayMode)
        match_list_srl.setOnRefreshListener {
            presenter.onViewPrepared(displayMode); match_list_srl.isRefreshing = true
        }
    }

    override fun openMatchDetailActivity(eventId: Int) {
        val bundle = Bundle()
        bundle.putInt(MatchDetailActivity.BUNDLE_KEY_EVENT_ID, eventId)
        startActivity(Intent(getBaseActivity(), MatchDetailActivity::class.java).putExtras(bundle))
    }

    override fun putDataMatchList(eventLeagueResponse: EventLeagueResponse) {
        mMatchListAdapter.addMatchList(eventLeagueResponse.events)
        match_list_srl.isRefreshing = false
    }

    override fun showProgress() {
        match_list_progress_bar.visible()
    }

    override fun hideProgress() {
        match_list_progress_bar.invisible()
    }
}
