package com.hskris.weathermvp.ui.forecast.domain.usecase

import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.data.repository.CityForecastRepository
import com.hskris.weathermvp.ui.UseCase
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class GetForecastTest : Spek({

    given("get forecast use case"){
        val repo: CityForecastRepository = mock()
        val getForecast = GetForecast(repo)
        on("execution"){
            getForecast.execute(1642911, object: UseCase.UseCaseCallback<CityForecast> {
                override fun onSuccess(response: CityForecast) {
                }
            })

            it("should run repo fetch forecast"){
                verify(repo).fetchForecastByCityId(any(), any())
            }
        }
    }

})