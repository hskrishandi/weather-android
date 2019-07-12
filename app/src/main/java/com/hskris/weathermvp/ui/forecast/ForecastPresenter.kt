package com.hskris.weathermvp.ui.forecast

import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.ui.UseCase
import com.hskris.weathermvp.ui.forecast.domain.usecase.GetForecast

class ForecastPresenter (private val getForecast: GetForecast, private val view: ForecastContract.View) : ForecastContract.Presenter{

    override fun onStart(){
        fetchForecast(1642911)
    }

    override fun fetchForecast(id: Int){
        getForecast.execute(id, object: UseCase.UseCaseCallback<CityForecast> {
            override fun onSuccess(response: CityForecast) {
                view.setWeatherDisplay(response)
            }
        })
    }
}