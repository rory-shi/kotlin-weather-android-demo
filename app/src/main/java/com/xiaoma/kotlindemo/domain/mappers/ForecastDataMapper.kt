package com.xiaoma.kotlindemo.domain.mappers

import com.xiaoma.kotlindemo.data.Forecast
import com.xiaoma.kotlindemo.data.ForecastResult
import com.xiaoma.kotlindemo.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import com.xiaoma.kotlindemo.domain.model.Forecast as ModelForecast

/**
 * Created by shixinghua on 05/06/2017.
 */
public class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>):
            List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}
