package com.xiaoma.kotlindemo.data

import com.google.gson.Gson
import java.net.URL

/**
 * Created by shixinghua on 24/05/2017.
 */
class ForecastRequest(val zipCode: String) {
    companion object {
        private val APP_ID = "6150ffe355cc7a43e0ccef72a197d848"
        private val URL = "http://api.openweathermap.org/data/2.5/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APP_ID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
//        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        val forecastJsonStr = URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=M%C3%BCnchen,DE&appid=6150ffe355cc7a43e0ccef72a197d848").readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)

    }
}

