package com.github.footballclubsubmission.ui.fragments.matchlist.view


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.data.models.EventLeagueResponse
import com.github.footballclubsubmission.ui.activities.matchdetail.view.MatchDetailActivity
import com.github.footballclubsubmission.ui.adapters.MatchListAdapter
import com.github.footballclubsubmission.ui.base.view.BaseFragment
import com.github.footballclubsubmission.ui.fragments.matchlist.interactor.MatchListMvpInteractor
import com.github.footballclubsubmission.ui.fragments.matchlist.presenter.MatchListMvpPresenter
import com.github.footballclubsubmission.utils.invisible
import com.github.footballclubsubmission.utils.visible
import kotlinx.android.synthetic.main.fragment_match_list.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject

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

        fun getSimpleName(context: Context, displayMode: Int): String {
            return when (displayMode) {
                DISPLAY_MODE_LAST_MATCH -> context.getString(R.string.last_match_simple_name)
                DISPLAY_MODE_NEXT_MATCH -> context.getString(R.string.next_match_simple_name)
                else -> MatchListFragment::class.java.simpleName
            }
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
            val displayMode: Int = arguments?.getInt(BUNDLE_KEY_DISPLAY_MODE) ?: 0
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
        getBaseActivity()?.applicationContext?.startActivity<MatchDetailActivity>(MatchDetailActivity.BUNDLE_KEY_EVENT_ID to eventId)
    }

    override fun putDataMatchList(eventLeagueResponse: EventLeagueResponse) {
        mMatchListAdapter.addMatchList(eventLeagueResponse.events)
        match_list_srl.isRefreshing = false
    }

    override fun showProgress() = match_list_progress_bar.visible()
    override fun hideProgress() = match_list_progress_bar.invisible()

}
