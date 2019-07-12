package com.hskris.weathermvp.ui.forecast

import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.ui.UseCase

class ForecastPresenter (private val getForecast: UseCase<Int, CityForecast>, private val view: ForecastContract.View) : ForecastContract.Presenter {

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