package com.hskris.weathermvp.di

import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.ui.UseCase
import com.hskris.weathermvp.ui.forecast.ForecastContract
import com.hskris.weathermvp.ui.forecast.ForecastPresenter
import com.hskris.weathermvp.ui.forecast.domain.usecase.GetForecast
import org.koin.dsl.module

val weatherAppModule = module {
    single<UseCase<Int, CityForecast>> { GetForecast() }
    factory<ForecastContract.Presenter> { (view: ForecastContract.View) -> ForecastPresenter(get(), view)}

}