package com.hskris.weathermvp.ui.forecast

import com.hskris.weathermvp.domain.models.City
import com.hskris.weathermvp.domain.models.CityForecast
import com.hskris.weathermvp.domain.UseCase
import com.hskris.weathermvp.domain.GetForecast
import com.nhaarman.mockitokotlin2.*
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class ForecastPresenterTest : Spek({
    given("forecast presenter"){

        val cityForecast = CityForecast(
            City(
                1642911,
                "Jakarta"
            )
        )
        val view: ForecastContract.View = mock()
        val getForecastMock: GetForecast = mock()

        val presenter = ForecastPresenter(getForecastMock, view)


        on("fetching forecast"){

            presenter.fetchForecast(1642911)
            val callbackCaptor = argumentCaptor<UseCase.UseCaseCallback<CityForecast>>()

            it("fetches from repo and sets weather display"){

                verify(getForecastMock).run(any(), callbackCaptor.capture())
                callbackCaptor.firstValue.onSuccess(cityForecast)
                verify(view).setWeatherDisplay(cityForecast)
            }
        }
    }
})