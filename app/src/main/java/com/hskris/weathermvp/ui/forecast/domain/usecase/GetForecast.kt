package com.hskris.weathermvp.ui.forecast.domain.usecase

import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.data.repository.CityForecastRepository
import com.hskris.weathermvp.ui.UseCase

class GetForecast(private val repository: CityForecastRepository) : UseCase<GetForecast.RequestValues, CityForecast> {

    override fun run(requestValues: RequestValues, callback: UseCase.UseCaseCallback<CityForecast>) {
        repository.fetchForecastByCityId(requestValues.id, object: CityForecastRepository.ResponseListener {
            override fun onResponse(response: CityForecast) {
                callback.onSuccess(response)
            }
        })
    }

    data class RequestValues(var id: Int) : UseCase.RequestValues

}