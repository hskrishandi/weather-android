package com.hskris.weathermvp.di

import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.data.repository.CityForecastRepository
import com.hskris.weathermvp.data.repository.remote.CityForecastRemoteRepository
import com.hskris.weathermvp.data.repository.remote.api.Api
import com.hskris.weathermvp.ui.UseCase
import com.hskris.weathermvp.ui.forecast.ForecastContract
import com.hskris.weathermvp.ui.forecast.ForecastPresenter
import com.hskris.weathermvp.ui.forecast.domain.usecase.GetForecast
import org.koin.dsl.module

val weatherAppModule = module {
    single<CityForecastRepository> { CityForecastRemoteRepository(Api.getInstance())}
    single<UseCase<GetForecast.RequestValues, CityForecast>> { GetForecast(get()) }
    factory<ForecastContract.Presenter> { (view: ForecastContract.View) -> ForecastPresenter(get(), view)}

}