package com.hskris.weathermvp.data.repository.remote.models

import com.google.gson.annotations.SerializedName

data class City (
	@SerializedName("id") val id: Int,
	@SerializedName("name") val name: String,
	@SerializedName("country") val country: String,
	@SerializedName("timezone") val timezone: Long
)