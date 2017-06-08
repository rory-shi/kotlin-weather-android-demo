package com.xiaoma.kotlindemo.domain.mappers

//import com.xiaoma.kotlindemo.data.Forecast
import com.xiaoma.kotlindemo.data.ForecastResult
import com.xiaoma.kotlindemo.domain.model.ForecastList
import com.xiaoma.kotlindemo.domain.model.ForecastWeather

/**
 * Created by shixinghua on 05/06/2017.
 */
public class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.coord.lon, forecast.coord.lat, convertWeather(forecast))
    }

    fun convertWeather(forecast: ForecastResult): ForecastWeather {
        return ForecastWeather(forecast.weather.map { it.description }[0], forecast.main.temp_max, forecast.main.temp_min)
    }
}
