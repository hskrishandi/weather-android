package com.hskris.weathermvp.ui.city

import com.hskris.weathermvp.domain.models.City
import com.hskris.weathermvp.domain.UseCase
import com.hskris.weathermvp.domain.GetCity

class CityPresenter(private val getCity: GetCity, private val view: CityContract.View): CityContract.Presenter {

    override fun onStart() {
        getCity.run(GetCity.RequestValues(), object: UseCase.UseCaseCallback<List<City>>{
            override fun onSuccess(response: List<City>) {
                view.setCities(response)
            }
        })

    }
}