package com.hskris.weathermvp.ui.city.domain.usecase

import com.hskris.weathermvp.data.models.City
import com.hskris.weathermvp.ui.UseCase

class GetCity : UseCase<GetCity.RequestValues, List<City>> {
    override fun run(requestValues: RequestValues, callback: UseCase.UseCaseCallback<List<City>>) {
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