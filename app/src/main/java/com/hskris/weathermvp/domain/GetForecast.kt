package com.hskris.weathermvp.domain

import com.hskris.weathermvp.domain.models.City
import com.hskris.weathermvp.domain.models.CityForecast
import com.hskris.weathermvp.domain.models.Forecast
import com.hskris.weathermvp.data.repository.CityForecastRepository
import com.hskris.weathermvp.data.repository.remote.models.CityForecastResponse
import java.util.*

class GetForecast(private val repository: CityForecastRepository) : UseCase<CityForecast> {

    override fun run(requestValues: UseCase.RequestValues, callback: UseCase.UseCaseCallback<CityForecast>) {

        repository.fetchForecastByCityId((requestValues as RequestValues).id, object: CityForecastRepository.ResponseListener {
            override fun onResponse(response: CityForecastResponse) {
                val parsed = parseResponseToModel(response)
                callback.onSuccess(parsed)
            }
        })
    }

    data class RequestValues(var id: Int) : UseCase.RequestValues

    private fun parseResponseToModel(response: CityForecastResponse): CityForecast {

        val cityResponse = response.city
        val city = City(
            cityResponse.id,
            cityResponse.name,
            cityResponse.country,
            cityResponse.timezone
        )

        val cityForecast = CityForecast(city)

        val forecastList = response.list
        for(forecast in forecastList){
            val date = forecast.dt
            val temp = forecast.main.temp
            val humidity = forecast.main.humidity
            val weather = forecast.weather[0].main
            val desc = forecast.weather[0].description

            cityForecast.addForecasts(
                Forecast(
                    Date(date * 1000),
                    temp,
                    humidity,
                    weather,
                    desc
                )
            )
        }

        return cityForecast
    }

}