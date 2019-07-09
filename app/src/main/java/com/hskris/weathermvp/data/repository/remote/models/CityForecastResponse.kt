package com.hskris.weathermvp.data.repository.remote.models

import com.google.gson.annotations.SerializedName

data class CityForecastResponse (
	@SerializedName("list") val list: List<Forecast>,
	@SerializedName("city") val city: City
)