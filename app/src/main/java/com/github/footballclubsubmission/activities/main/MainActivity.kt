package com.github.footballclubsubmission.activities.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.adapters.MainAdapter
import com.github.footballclubsubmission.ankoView.MainActivityUi
import com.github.footballclubsubmission.data.models.Team
import com.github.footballclubsubmission.data.network.ApiRepository
import com.github.footballclubsubmission.utils.Utils
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.onRefresh

class MainActivity : AppCompatActivity(), MainView {

    private var teams: MutableList<Team> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter

    private lateinit var leagueName: String

    private lateinit var mainActivityUi: MainActivityUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityUi = MainActivityUi()
        mainActivityUi.setContentView(this)
        setAdapter()
        setPresenter()
        initSpinner()
    }

    private fun initSpinner() {
        val spinnerItems = resources.getStringArray(R.array.league)
        val spinnerAdapter = ArrayAdapter(ctx, android.R.layout.simple_spinner_dropdown_item, spinnerItems)
        mainActivityUi.spinner.adapter = spinnerAdapter
        setSpinner()
    }

    private fun setSpinner() {
        mainActivityUi.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(_parent: AdapterView<*>?, _view: View?, _position: Int, _id: Long) {
                leagueName = mainActivityUi.spinner.selectedItem.toString()
                presenter.getTeamList(leagueName)
            }

            override fun onNothingSelected(_parent: AdapterView<*>?) {}
        }
    }

    private fun setPresenter() {
        val request = ApiRepository()
        val gson = Gson()
        presenter = MainPresenter(this, request, gson)
    }

    private fun setAdapter() {
        adapter = MainAdapter(teams)
        mainActivityUi.listTeam.adapter = adapter
    }

    override fun showLoading() {
        mainActivityUi.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        mainActivityUi.progressBar.visibility = View.INVISIBLE
    }

    override fun showTeamList(data: List<Team>) {
        mainActivityUi.swipeRefresh.isRefreshing = true
        teams.clear()
        teams.addAll(data)
        adapter.notifyDataSetChanged()
        mainActivityUi.swipeRefresh.onRefresh {
            presenter.getTeamList(leagueName)
        }
    }

}
