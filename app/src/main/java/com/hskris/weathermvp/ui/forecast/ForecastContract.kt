package com.hskris.weathermvp.ui.forecast

import com.hskris.weathermvp.data.models.CityForecast

interface ForecastContract {

    interface Presenter {
        fun onStart()
        fun fetchForecast(id: Int)
    }

    interface View {
        fun setWeatherDisplay(cityForecast: CityForecast)
    }

}