package com.hskris.weathermvp.ui

interface UseCase<P, R> {

    fun execute(requestValues: P, callback: UseCaseCallback<R>)

    interface UseCaseCallback<R> {
        fun onSuccess(response: R)
    }
}