package com.hskris.weathermvp.ui.forecast

import com.hskris.weathermvp.domain.models.CityForecast
import com.hskris.weathermvp.domain.UseCase
import com.hskris.weathermvp.domain.GetForecast

class ForecastPresenter (private val getForecast: GetForecast, private val view: ForecastContract.View) : ForecastContract.Presenter {

    override fun onStart(){
        fetchForecast(1642911)
    }

    override fun fetchForecast(id: Int){

        val requestValues = GetForecast.RequestValues(id)

        getForecast.run(requestValues, object: UseCase.UseCaseCallback<CityForecast> {
            override fun onSuccess(response: CityForecast) {
                view.setWeatherDisplay(response)
            }
        })
    }
}