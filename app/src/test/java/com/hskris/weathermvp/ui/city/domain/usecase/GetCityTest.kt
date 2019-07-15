package com.hskris.weathermvp.ui.city.domain.usecase

import com.hskris.weathermvp.data.models.City
import com.hskris.weathermvp.ui.UseCase
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert.assertEquals

class GetCityTest : Spek({
    given("get city use case"){
        val getCity = GetCity()
        on("execution"){

            getCity.run(GetCity.RequestValues(), object: UseCase.UseCaseCallback<List<City>> {
                override fun onSuccess(response: List<City>) {
                    it("fetches city items") {
                        assertEquals(response, GetCity.cityItems)
                    }
                }
            })
        }
    }

})