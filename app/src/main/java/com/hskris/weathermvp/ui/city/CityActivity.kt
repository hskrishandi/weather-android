package com.hskris.weathermvp.ui.city

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hskris.weathermvp.R
import com.hskris.weathermvp.data.models.City
import kotlinx.android.synthetic.main.activity_city.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class CityActivity : AppCompatActivity(), CityContract.View {

    companion object {
        const val CITY_KEY = "CITY_KEY"
    }

    private val cityAdapter = CityAdapter(emptyList())
    private val presenter: CityContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        recyclerViewChooseCity.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = cityAdapter
        }

        presenter.onStart()
    }

    override fun setCities(city: List<City>) {
        cityAdapter.updateCities(city)
    }



}
