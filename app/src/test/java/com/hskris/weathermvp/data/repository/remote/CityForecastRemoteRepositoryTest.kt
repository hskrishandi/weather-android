package com.hskris.weathermvp.data.repository.remote

import com.hskris.weathermvp.domain.models.CityForecast
import com.hskris.weathermvp.data.repository.CityForecastRepository
import com.hskris.weathermvp.data.repository.remote.api.ApiService
import com.hskris.weathermvp.data.repository.remote.models.CityForecastResponse
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import retrofit2.Call

class CityForecastRemoteRepositoryTest : Spek({

    given("API service"){

        val call : Call<CityForecastResponse> = mock()
        val api : ApiService = mock()
        whenever(api.getByCityId(any())).thenReturn(call)

        val repo = CityForecastRemoteRepository(api)

        on("fetching city forecast"){
            repo.fetchForecastByCityId(1642911, object: CityForecastRepository.ResponseListener {
                override fun onResponse(cityForecast: CityForecast) {}
            })

            it("calls api to fetch"){
                verify(api).getByCityId(1642911)
            }
        }
    }
})