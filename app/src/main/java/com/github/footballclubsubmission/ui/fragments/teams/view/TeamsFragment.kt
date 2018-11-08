package com.github.footballclubsubmission.ui.fragments.teams.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.github.footballclubsubmission.R
import com.github.footballclubsubmission.ui.base.view.BaseFragment

/**
 * A simple [Fragment] subclass.
 *
 */
class TeamsFragment : BaseFragment(), TeamsMvpView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun setUp() {}



}