package com.xiaoma.kotlindemo.data.db

import com.xiaoma.kotlindemo.domain.model.ForecastList
import com.xiaoma.kotlindemo.extensions.clear
import com.xiaoma.kotlindemo.extensions.parseList
import com.xiaoma.kotlindemo.extensions.parseOpt
import com.xiaoma.kotlindemo.extensions.toVaraargArray

import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
 * Created by shixinghua on 09/06/2017.
 */
class ForecastDb(val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 val dataMapper: DbDataMapper = DbDataMapper()) {

    fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {

        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipCode.toString(), date.toString())
                .parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME)
                .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt { CityForecast(HashMap(it), dailyForecast) }

        if (city != null) dataMapper.convertToDomain(city) else null
    }

    fun saveForecast(forecast: ForecastList) = forecastDbHelper.use {

        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.NAME, *map.toVaraargArray())
            dailyForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVaraargArray()) }
        }
    }
}