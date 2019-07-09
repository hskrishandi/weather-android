package com.hskris.weathermvp.data.repository.api.models

import com.google.gson.annotations.SerializedName

data class Main (
	@SerializedName("temp") val temp: Double,
	@SerializedName("humidity") val humidity: Int
)