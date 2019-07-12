package com.hskris.weathermvp.utils

import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.data.models.Forecast
import com.hskris.weathermvp.types.DayNightType
import java.util.*

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

fun getDayNight(timezone: Long): DayNightType {
    var unixtime = System.currentTimeMillis() / 1000L
    unixtime += timezone

    val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
    calendar.time = Date(unixtime*1000)
    val hour = calendar.get(Calendar.HOUR_OF_DAY)

    return when(hour in 6..17) {
        true -> DayNightType.DAY
        false -> DayNightType.NIGHT
    }
}
