package com.hskris.weathermvp.data.repository.remote

import android.util.Log
import com.hskris.weathermvp.data.repository.CityForecastRepository
import com.hskris.weathermvp.data.repository.remote.api.ApiService
import com.hskris.weathermvp.data.repository.remote.models.CityForecastResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CityForecastRemoteRepository(private val api : ApiService) : CityForecastRepository {

    override fun fetchForecastByCityId(id: Int, listener: CityForecastRepository.ResponseListener) {

        val result = api.getByCityId(id)
        result.enqueue(object : Callback<CityForecastResponse> {
            override fun onFailure(call: Call<CityForecastResponse>, t: Throwable) {
                Log.d("Repository", "Error: ${t.message}")
            }

            override fun onResponse(call: Call<CityForecastResponse>, response: Response<CityForecastResponse>) {
                response.body()?.let {
                    listener.onResponse(it)
                }
            }

        })

    }
}