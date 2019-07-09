package com.hskris.weathermvp.data.repository.api.models

import com.google.gson.annotations.SerializedName

data class Forecast (
	@SerializedName("dt") val dt: Long,
	@SerializedName("main") val main: Main,
	@SerializedName("weather") val weather: List<Weather>
)