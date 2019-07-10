package com.hskris.weathermvp.ui.forecast

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hskris.weathermvp.R
import com.hskris.weathermvp.data.models.Forecast
import java.util.Calendar
import java.util.Locale

class ForecastAdapter (var items: List<Forecast>) : RecyclerView.Adapter<ForecastAdapter.ForecastItem>(){

    private val calendar = Calendar.getInstance()

    fun updateForecast(newItems: List<Forecast>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastItem {
        return ForecastItem(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.forecast_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ForecastItem, position: Int) {
        val item = items[position]

        val date = item.date
        calendar.setTime(date)
        holder.day.text = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US)?.toString()

        val temp = item.temp.toInt().toString() + " C"
        holder.temp.text = temp

        holder.desc.text = item.weather
    }


    class ForecastItem(itemView: View): RecyclerView.ViewHolder(itemView) {
        val day: TextView = itemView.findViewById(R.id.textViewDay)
        val temp: TextView = itemView.findViewById(R.id.textViewTemp)
        val desc: TextView = itemView.findViewById(R.id.textViewDescription)
    }
}