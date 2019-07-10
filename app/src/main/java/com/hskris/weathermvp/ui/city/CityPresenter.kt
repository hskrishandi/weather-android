package com.hskris.weathermvp.ui.city

import com.hskris.weathermvp.data.models.City

class CityPresenter(val view: CityContract.View): CityContract.Presenter {

    companion object {
        val cityItems = listOf(
            City(1642911, "Jakarta"),
            City(1277333, "Bangalore"),
            City(1819729, "Hong Kong"),
            City(5128581, "New York"),
            City(7839805, "Melbourne"),
            City(6094817, "Ottawa")
        )
    }

    override fun onStart() {
        view.setCities(cityItems)
    }
}