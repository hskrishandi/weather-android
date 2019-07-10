package com.hskris.weathermvp.ui.city

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hskris.weathermvp.R
import com.hskris.weathermvp.data.models.City
import kotlinx.android.synthetic.main.activity_city.*

class CityActivity : AppCompatActivity(), CityContract.View {

    private val cityAdapter = CityAdapter(emptyList())
    private val presenter = CityPresenter(this)

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
