package com.hskris.weathermvp.ui.forecast

import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.data.repository.CityForecastRepository
import com.hskris.weathermvp.data.repository.remote.CityForecastRemoteRepository
import com.hskris.weathermvp.data.repository.remote.api.Api

interface ForecastView {
    fun setWeatherDisplay(cityForecast: CityForecast)
}

class ForecastPresenter(
    private val view: ForecastView,
    private val repository: CityForecastRepository = CityForecastRemoteRepository(Api.getInstance())
) {

    fun onStart(){
        repository.fetchForecastByCityId(1642911, object: CityForecastRepository.ResponseListener {
            override fun onResponse(cityForecast: CityForecast) {
                view.setWeatherDisplay(cityForecast)
            }
        })
    }
}