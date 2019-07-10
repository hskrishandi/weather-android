package com.hskris.weathermvp.ui.city

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hskris.weathermvp.R
import com.hskris.weathermvp.data.models.City

class CityAdapter(var items: List<City>) : RecyclerView.Adapter<CityAdapter.CityItem>(){

    fun updateCities(newItems: List<City>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityItem {
        return CityItem(
            LayoutInflater.from(parent.context).inflate(
                R.layout.city_row,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CityItem, position: Int) {
        holder.city.text = items[position].name
    }


    class CityItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val city: TextView = itemView.findViewById(R.id.textViewCityRow)
    }

}