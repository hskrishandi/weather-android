package com.hskris.weathermvp.ui.forecast.domain.usecase

import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.data.repository.CityForecastRepository
import com.hskris.weathermvp.ui.UseCase

class GetForecast(private val repository: CityForecastRepository) : UseCase<Int, CityForecast> {

    override fun execute(requestValues: Int, callback: UseCase.UseCaseCallback<CityForecast>) {

        repository.fetchForecastByCityId(requestValues, object: CityForecastRepository.ResponseListener {
            override fun onResponse(response: CityForecast) {
                callback.onSuccess(response)
            }
        })
    }

}