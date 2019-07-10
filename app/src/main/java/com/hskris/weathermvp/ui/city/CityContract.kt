package com.hskris.weathermvp.ui.city

import com.hskris.weathermvp.data.models.City

interface CityContract {

    interface Presenter {
        fun onStart()
    }

    interface View {
        fun setCities(city: List<City>)
    }

}