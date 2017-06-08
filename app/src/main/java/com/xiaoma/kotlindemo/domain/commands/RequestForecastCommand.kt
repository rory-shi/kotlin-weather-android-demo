package com.xiaoma.kotlindemo.domain.commands

import com.xiaoma.kotlindemo.data.ForecastRequest
import com.xiaoma.kotlindemo.domain.mappers.ForecastDataMapper
import com.xiaoma.kotlindemo.domain.model.ForecastList

/**
 * Created by shixinghua on 06/06/2017.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}