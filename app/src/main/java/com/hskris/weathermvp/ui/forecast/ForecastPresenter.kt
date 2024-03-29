package com.hskris.weathermvp.ui.forecast

import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.data.repository.CityForecastRepository
import com.hskris.weathermvp.data.repository.remote.CityForecastRemoteRepository
import com.hskris.weathermvp.data.repository.remote.api.Api

class ForecastPresenter (
    private val view: ForecastContract.View,
    private val repository: CityForecastRepository = CityForecastRemoteRepository(Api.getInstance())
) : ForecastContract.Presenter{

    override fun onStart(){
        fetchForecast(1642911)
    }

    fun fetchForecast(id: Int){
        repository.fetchForecastByCityId(id, object: CityForecastRepository.ResponseListener {
            override fun onResponse(cityForecast: CityForecast) {
                view.setWeatherDisplay(cityForecast)
            }
        })
    }
}