package com.hskris.weathermvp.ui.city

import com.hskris.weathermvp.data.models.City
import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.data.repository.CityForecastRepository
import com.hskris.weathermvp.ui.forecast.ForecastPresenter
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert.assertEquals

class CityPresenterTest : Spek({
    given("city presenter"){

        val view: CityContract.View = mock()
        val presenter = CityPresenter(view)

        on("starting"){
            presenter.onStart()

            val citiesCaptor = argumentCaptor<List<City>>()

            it("sets cities"){

                verify(view).setCities(citiesCaptor.capture())
                assertEquals(CityPresenter.cityItems, citiesCaptor.firstValue)
            }
        }
    }
})