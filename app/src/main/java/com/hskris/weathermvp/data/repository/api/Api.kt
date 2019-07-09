package com.hskris.weathermvp.data.repository.api

import com.hskris.weathermvp.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Api {

    companion object {
        const val API_KEY = BuildConfig.API_KEY
        private const val API_URL = BuildConfig.API_URL
        private var retrofit: Retrofit? = null

        fun getInstance(): ApiService {
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit
                    .Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(API_URL)
                    .build()
            }
            return retrofit!!.create(ApiService::class.java)
        }
    }
}