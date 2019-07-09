package com.hskris.weathermvp.data.repository.api

import com.hskris.weathermvp.data.repository.api.models.CityForecastResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("forecast?APPID=" + Api.API_KEY)
    fun getByCityId(@Query("id") cityId: Int): Call<CityForecastResponse>

}