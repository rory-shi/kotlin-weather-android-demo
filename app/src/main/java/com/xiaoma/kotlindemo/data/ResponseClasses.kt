package com.xiaoma.kotlindemo.data

/**
 * Created by shixinghua on 05/06/2017.
 */
/*

data class ForecastResult(val city: City, val list: List<Forecast>)
data class City(val id: Long, val name: String, val coord: Coordinates,
                val country: String, val population: Int)
data class Coordinates(val lon: Float, val lat: Float)
data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float,
                    val humidity: Int, val weather: List<Weather>,
                    val speed: Float, val deg: Int, val clouds: Int,
                    val rain: Float)
data class Temperature(val day: Float, val min: Float, val max: Float,
                       val night: Float, val eve: Float, val morn: Float)
data class Weather(val id: Long, val main: String, val description: String,
                   val icon: String)
*/

data class ForecastResult(val coord: Coord, val weather: List<Weather>, val base: String,
                          val main: Main, val visibility: Long, val wind: Wind,
                          val clouds: Clouds, val dt: String, val sys: Sys, val id: Long,
                          val name: String, val cod: Int)

data class Coord(val lon: Double, val lat: Double)
data class Weather(val id: Int, val main: String, val description: String, val icon: String)
data class Main(val temp: Double, val pressure: Int, val humidity: Int, val temp_min: Float, val temp_max: Float)
data class Wind(val speed: Float, val deg: Int)
data class Clouds(val all: Int)
data class Sys(val type: Int, val id: Int, val message: Double, val country: String, val sunrise: Int, val sunset: Int)


