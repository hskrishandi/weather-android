package com.hskris.weathermvp.ui.forecast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hskris.weathermvp.R
import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.types.DayNightType
import kotlinx.android.synthetic.main.activity_forecast.*
import java.util.*

class ForecastActivity : AppCompatActivity(), ForecastContract.View {

    private val forecastAdapter = ForecastAdapter(emptyList())
    private val presenter = ForecastPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        supportActionBar?.hide()

        recyclerViewForecast.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = forecastAdapter
        }

        presenter.onStart()

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

        textViewBigTemp.text = currentForecast.temp.toInt().toString()
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

       forecastAdapter.updateForecast(forecasts)

    }

    fun getDayNight(timezone: Long): DayNightType {
        var unixtime = System.currentTimeMillis() / 1000L
        unixtime += timezone

        val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        calendar.time = Date(unixtime*1000)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)

        when(hour in 6..17) {
            true -> return DayNightType.DAY
            false -> return DayNightType.NIGHT
        }
    }
}
