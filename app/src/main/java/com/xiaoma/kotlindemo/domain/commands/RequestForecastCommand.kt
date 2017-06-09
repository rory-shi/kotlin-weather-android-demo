package com.xiaoma.kotlindemo.domain.commands

import com.xiaoma.kotlindemo.data.server.ForecastRequest
import com.xiaoma.kotlindemo.domain.mappers.ForecastDataMapper
import com.xiaoma.kotlindemo.domain.model.ForecastList

/**
 * Created by shixinghua on 06/06/2017.
 */
class RequestForecastCommand(private val zipCode: Long) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(zipCode, forecastRequest.execute())
    }
}