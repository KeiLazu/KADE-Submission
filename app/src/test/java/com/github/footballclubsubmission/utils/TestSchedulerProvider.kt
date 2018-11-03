package com.github.footballclubsubmission.utils

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/3/2018
 *  check https://github.com/KeiLazu for more
 */
class TestSchedulerProvider(private val testScheduler: TestScheduler): SchedulerProvider {

    override fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T> = ObservableTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
    }

    override fun <T> ioToMainSingleScheduler(): SingleTransformer<T, T> = SingleTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
    }


    override fun ioToMainCompletableScheduler(): CompletableTransformer = CompletableTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
    }


    override fun <T> ioToMainFlowableScheduler(): FlowableTransformer<T, T> = FlowableTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
    }


    override fun <T> ioToMainMaybeScheduler(): MaybeTransformer<T, T> = MaybeTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
    }

    private fun getIOThreadScheduler() = testScheduler

    private fun getMainThreadScheduler() = testScheduler
}