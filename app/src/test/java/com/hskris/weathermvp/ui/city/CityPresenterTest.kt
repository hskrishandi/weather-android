package com.hskris.weathermvp.ui.city

import com.hskris.weathermvp.data.models.City
import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.data.repository.CityForecastRepository
import com.hskris.weathermvp.ui.UseCase
import com.hskris.weathermvp.ui.city.domain.usecase.GetCity
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

        val getCity: GetCity = mock()
        val view: CityContract.View = mock()
        val presenter = CityPresenter(getCity, view)

        on("starting"){
            presenter.onStart()

            val callbackCaptor = argumentCaptor<UseCase.UseCaseCallback<List<City>>>()

            it("sets cities"){

                verify(getCity).run(any(), callbackCaptor.capture())
                callbackCaptor.firstValue.onSuccess(GetCity.cityItems)
                verify(view).setCities(GetCity.cityItems)
            }
        }
    }
})