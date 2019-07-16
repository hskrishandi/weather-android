package com.hskris.weathermvp.domain.models

class CityForecast(val city: City) {

    private val forecasts: ArrayList<Forecast> = arrayListOf()

    fun addForecasts(forecast: Forecast){
        forecasts.add(forecast)
    }

    fun getForecasts(): ArrayList<Forecast> {
        return forecasts
    }

}