package com.hskris.weathermvp.utils

import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.data.models.Forecast

fun getFiveDaysForecast(cityForecast: CityForecast): List<Forecast>{

    val forecasts = cityForecast.getForecasts()

    val selectedForecast = mutableListOf<Forecast>()
    for (i in 0..4) {
        val index = i * 8
        if (index < forecasts.size)
            selectedForecast.add(forecasts[index])
    }

    return selectedForecast
}

