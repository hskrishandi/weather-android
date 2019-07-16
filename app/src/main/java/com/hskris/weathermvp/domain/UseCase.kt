package com.hskris.weathermvp.domain

interface UseCase<R> {

    fun run(requestValues: RequestValues, callback: UseCaseCallback<R>)

    interface RequestValues

    interface UseCaseCallback<R> {
        fun onSuccess(response: R)
    }
}