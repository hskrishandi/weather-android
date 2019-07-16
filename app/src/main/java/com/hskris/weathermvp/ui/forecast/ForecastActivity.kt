package com.hskris.weathermvp.ui.forecast

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hskris.weathermvp.R
import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.types.DayNightType
import com.hskris.weathermvp.ui.city.CityActivity
import com.hskris.weathermvp.utils.*
import kotlinx.android.synthetic.main.activity_forecast.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class ForecastActivity : AppCompatActivity(), ForecastContract.View {

    companion object {
        const val CHOOSE_CITY = 1
    }

    private val forecastAdapter = ForecastAdapter(emptyList())
    private val presenter: ForecastContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        supportActionBar?.hide()

        recyclerViewForecast.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = forecastAdapter
        }

        textViewChooseCity.setOnClickListener {
            val intent = Intent(this, CityActivity::class.java)
            startActivityForResult(intent, CHOOSE_CITY)
        }

        presenter.onStart()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == CHOOSE_CITY && resultCode == Activity.RESULT_OK){
            val cityId = data!!.getIntExtra(CityActivity.CITY_KEY, -1)
            presenter.fetchForecast(cityId)
        }
    }

    override fun setWeatherDisplay(cityForecast: CityForecast) {

        val city = cityForecast.city
        val forecasts = cityForecast.getForecasts()
        val currentForecast = forecasts[0]

        val textCity = "${city.name}, ${city.country}"

        val dayNight = getDayNight(city.timezone)

        when(dayNight){
            DayNightType.DAY -> forecastLayout.setBackgroundResource(R.drawable.day)
            DayNightType.NIGHT -> forecastLayout.setBackgroundResource(R.drawable.night)
        }

        textViewBigTemp.text = "${currentForecast.temp.toInt()}"
        textViewCity.text = textCity
        textViewDescription.text = currentForecast.description

        when(currentForecast.weather){
            "Clouds" -> imageViewWeather.setImageResource(R.drawable.cloudy)
            "Rain" -> imageViewWeather.setImageResource(R.drawable.rainy)
            "Clear" ->
                when(dayNight){
                    DayNightType.DAY -> imageViewWeather.setImageResource(R.drawable.clear)
                    DayNightType.NIGHT -> imageViewWeather.setImageResource(R.drawable.moon)
                }
        }

        val fiveDaysForecasts = getFiveDaysForecast(cityForecast)

        forecastAdapter.updateForecast(fiveDaysForecasts)

    }
}
