package com.hskris.weathermvp.ui.forecast

import com.hskris.weathermvp.data.models.City
import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.ui.UseCase
import com.nhaarman.mockitokotlin2.*
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class ForecastPresenterTest : Spek({
    given("forecast presenter"){

        val cityForecast = CityForecast(City(1642911, "Jakarta"))
        val view: ForecastContract.View = mock()
        val getForecastMock: UseCase<Int, CityForecast> = mock()

        val presenter = ForecastPresenter(getForecastMock, view)


        on("fetching forecast"){

            presenter.fetchForecast(1642911)
            val callbackCaptor = argumentCaptor<UseCase.UseCaseCallback<CityForecast>>()

            it("fetches from repo and sets weather display"){

                verify(getForecastMock).execute(any(), callbackCaptor.capture())
                callbackCaptor.firstValue.onSuccess(cityForecast)
                verify(view).setWeatherDisplay(cityForecast)
            }
        }
    }
})