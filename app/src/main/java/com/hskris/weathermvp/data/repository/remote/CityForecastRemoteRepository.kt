package com.hskris.weathermvp.data.repository.remote

import android.util.Log
import com.hskris.weathermvp.data.models.City
import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.data.models.Forecast
import com.hskris.weathermvp.data.repository.CityForecastRepository
import com.hskris.weathermvp.data.repository.remote.api.ApiService
import com.hskris.weathermvp.data.repository.remote.models.CityForecastResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Date

class CityForecastRemoteRepository(private val api : ApiService) : CityForecastRepository {

    override fun fetchForecastByCityId(id: Int, listener: CityForecastRepository.ResponseListener) {

        val result = api.getByCityId(id)
        result.enqueue(object : Callback<CityForecastResponse> {
            override fun onFailure(call: Call<CityForecastResponse>, t: Throwable) {
                Log.d("Repository", "Error: ${t.message}")
            }

            override fun onResponse(call: Call<CityForecastResponse>, response: Response<CityForecastResponse>) {
                response.body()?.let {
                    val parsed = parseResponseToModel(it)
                    listener.onResponse(parsed)
                }
            }

        })

    }

    private fun parseResponseToModel(response: CityForecastResponse): CityForecast {

        val cityResponse = response.city
        val city = City (
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

            cityForecast.addForecasts(Forecast(Date(date * 1000), temp, humidity, weather, desc))
        }

        return cityForecast
    }
}