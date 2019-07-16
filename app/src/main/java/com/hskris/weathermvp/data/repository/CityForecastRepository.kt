package com.hskris.weathermvp.data.repository

import com.hskris.weathermvp.data.repository.remote.models.CityForecastResponse

interface CityForecastRepository {
    interface ResponseListener {
        fun onResponse(response: CityForecastResponse)
    }

    fun fetchForecastByCityId(id: Int, listener: ResponseListener)
}