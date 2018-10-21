package com.github.footballclubsubmission.ui.base.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 10/20/2018
 *  check https://github.com/KeiLazu for more
 */
abstract class BaseActivity : AppCompatActivity(), MvpView, BaseFragment.Callback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
    }

    override fun showProgress() {}

    override fun hideProgress() {}

    private fun performDI() = AndroidInjection.inject(this)
}