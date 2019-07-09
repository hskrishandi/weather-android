package com.hskris.weathermvp.data.repository

import com.hskris.weathermvp.data.models.CityForecast

interface CityForecastRepository {
    interface ResponseListener {
        fun onResponse(cityForecast: CityForecast)
    }

    fun fetchForecastByCityId(id: Int, listener: ResponseListener)
}