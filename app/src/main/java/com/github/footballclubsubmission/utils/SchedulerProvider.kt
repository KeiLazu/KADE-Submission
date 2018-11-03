package com.github.footballclubsubmission.utils

import io.reactivex.*

/**
 *  Created by Kei Lazu (Kennix Lazuardi) on 11/3/2018
 *  check https://github.com/KeiLazu for more
 */
interface SchedulerProvider {
    fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T>
    fun <T> ioToMainSingleScheduler(): SingleTransformer<T, T>
    fun ioToMainCompletableScheduler(): CompletableTransformer
    fun <T> ioToMainFlowableScheduler(): FlowableTransformer<T, T>
    fun <T> ioToMainMaybeScheduler(): MaybeTransformer<T, T>
}