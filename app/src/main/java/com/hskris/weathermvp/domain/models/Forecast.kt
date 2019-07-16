package com.hskris.weathermvp.domain.models

import java.util.Date

data class Forecast (
    val date: Date?,
    val temp: Double,
    val humidity: Int,
    val weather: String,
    val description: String
)