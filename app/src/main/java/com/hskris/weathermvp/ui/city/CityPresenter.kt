package com.hskris.weathermvp.ui.city

import com.hskris.weathermvp.data.models.City
import com.hskris.weathermvp.ui.UseCase
import com.hskris.weathermvp.ui.city.domain.usecase.GetCity

class CityPresenter(private val getCity: GetCity, private val view: CityContract.View): CityContract.Presenter {

    override fun onStart() {
        getCity.run(GetCity.RequestValues(), object: UseCase.UseCaseCallback<List<City>>{
            override fun onSuccess(response: List<City>) {
                view.setCities(response)
            }
        })

    }
}