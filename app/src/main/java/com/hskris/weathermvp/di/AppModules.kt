package com.hskris.weathermvp.di

import com.hskris.weathermvp.data.models.City
import com.hskris.weathermvp.data.models.CityForecast
import com.hskris.weathermvp.data.repository.CityForecastRepository
import com.hskris.weathermvp.data.repository.remote.CityForecastRemoteRepository
import com.hskris.weathermvp.data.repository.remote.api.Api
import com.hskris.weathermvp.ui.UseCase
import com.hskris.weathermvp.ui.city.CityContract
import com.hskris.weathermvp.ui.city.CityPresenter
import com.hskris.weathermvp.ui.city.domain.usecase.GetCity
import com.hskris.weathermvp.ui.forecast.ForecastContract
import com.hskris.weathermvp.ui.forecast.ForecastPresenter
import com.hskris.weathermvp.ui.forecast.domain.usecase.GetForecast
import org.koin.dsl.module

val weatherAppModule = module {
    single<CityForecastRepository> { CityForecastRemoteRepository(Api.getInstance())}
    factory { GetForecast(get()) }
    factory<ForecastContract.Presenter> { (view: ForecastContract.View) -> ForecastPresenter(get(), view)}

    factory { GetCity()}
    factory<CityContract.Presenter> { (view: CityContract.View) -> CityPresenter(get(), view) }

}