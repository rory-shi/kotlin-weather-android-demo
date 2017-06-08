package com.xiaoma.kotlindemo.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.xiaoma.kotlindemo.domain.model.ForecastList

/**
 * Created by shixinghua on 23/05/2017.
 */

class ForecastListAdapter(
        val todayForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        with(todayForecast[position]) {
//            holder.textview.text = "$date - $description - $high/$low"
//        }
        with(todayForecast) {
            val high = weather.high
            val low = weather.low
            holder.textview.text = "$lon - $lat - $high/$low"

        }
    }

    class ViewHolder(val textview: TextView) : RecyclerView.ViewHolder(textview)

    public interface OnitemClickListener {
        operator fun invoke(forecast: ForecastList)
    }
}