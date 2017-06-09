package com.xiaoma.kotlindemo.domain.mappers

import com.xiaoma.kotlindemo.data.server.Forecast
import com.xiaoma.kotlindemo.data.server.ForecastResult
import com.xiaoma.kotlindemo.domain.model.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit
import com.xiaoma.kotlindemo.domain.model.Forecast as ModelForecast

/**
 * Created by shixinghua on 05/06/2017.
 */
public class ForecastDataMapper {

    fun convertFromDataModel(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode, city.name, city.country, convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(forecast.dt, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}
