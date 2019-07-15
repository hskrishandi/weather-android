package com.hskris.weathermvp.ui

interface UseCase<P : UseCase.RequestValues, R> {

    fun run(requestValues: P, callback: UseCaseCallback<R>)

    interface RequestValues

    interface UseCaseCallback<R> {
        fun onSuccess(response: R)
    }
}