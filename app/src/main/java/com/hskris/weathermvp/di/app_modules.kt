package com.hskris.weathermvp.di

import com.hskris.weathermvp.ui.forecast.ForecastContract
import com.hskris.weathermvp.ui.forecast.ForecastPresenter
import com.hskris.weathermvp.ui.forecast.domain.usecase.GetForecast
import org.koin.dsl.module

val weatherAppModule = module {
    single { GetForecast() }
    factory { (view: ForecastContract.View) -> ForecastPresenter(get(), view) as ForecastContract.Presenter}

}