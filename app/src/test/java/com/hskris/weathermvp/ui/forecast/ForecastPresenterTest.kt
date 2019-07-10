package com.hskris.weathermvp.ui.forecast

import com.hskris.weathermvp.data.models.City
import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.data.repository.CityForecastRepository
import com.nhaarman.mockitokotlin2.*
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class ForecastPresenterTest : Spek({
    given("forecast presenter"){

        val cityForecast = CityForecast(City(1642911, "Jakarta"))
        val view: ForecastContract.View = mock()
        val repo: CityForecastRepository = mock()
        val presenter = ForecastPresenter(view, repo)

        on("fetching forecast"){

            presenter.fetchForecast(1642911)

            val listenerCaptor = argumentCaptor<CityForecastRepository.ResponseListener>()

            it("fetches from repo and sets weather display"){

                verify(repo).fetchForecastByCityId(any(), listenerCaptor.capture())
                listenerCaptor.firstValue.onResponse(cityForecast)
                verify(view).setWeatherDisplay(cityForecast)
            }
        }
    }
})