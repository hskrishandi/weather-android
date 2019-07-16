package com.hskris.weathermvp.domain

import com.hskris.weathermvp.domain.models.City

class GetCity : UseCase<List<City>> {
    override fun run(requestValues: UseCase.RequestValues, callback: UseCase.UseCaseCallback<List<City>>) {
        callback.onSuccess(cityItems)
    }

    class RequestValues() : UseCase.RequestValues

    companion object {
        val cityItems = listOf(
            City(1642911, "Jakarta"),
            City(1277333, "Bangalore"),
            City(1819729, "Hong Kong"),
            City(5128581, "New York"),
            City(7839805, "Melbourne"),
            City(6094817, "Ottawa")
        )
    }
}