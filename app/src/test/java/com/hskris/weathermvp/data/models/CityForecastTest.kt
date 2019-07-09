package com.hskris.weathermvp.data.models

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert.assertEquals
import java.util.Date

class CityForecastTest : Spek({
    given("CityForecast") {
        val cityForecast = CityForecast(City(1, "Jakarta"))
        on("adding forecast") {
            val forecast = Forecast(Date(), 20.2, 10, "Rainy", "Light rain")
            cityForecast.addForecasts(forecast)
            it("arraylist is inserted with the forecast"){
                val result = cityForecast.getForecasts()
                assertEquals(forecast, result[0])
            }
        }
    }
})
