package com.hskris.weathermvp.data.models

data class City(val id: Int, val name: String, var country: String = "", var timezone: Long = 0)