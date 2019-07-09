package com.hskris.weathermvp.data.repository.api.models

import com.google.gson.annotations.SerializedName

data class CityForecastResponse (
	@SerializedName("list") val list: List<Forecast>,
	@SerializedName("city") val city: City
)