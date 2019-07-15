package com.hskris.weathermvp.ui.forecast

import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.ui.UseCase
import com.hskris.weathermvp.ui.forecast.domain.usecase.GetForecast

class ForecastPresenter (private val getForecast: UseCase<GetForecast.RequestValues, CityForecast>, private val view: ForecastContract.View) : ForecastContract.Presenter {

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