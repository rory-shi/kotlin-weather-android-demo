package com.xiaoma.kotlindemo.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.xiaoma.kotlindemo.domain.model.ForecastList

/**
 * Created by shixinghua on 23/05/2017.
 */

class ForecastListAdapter(
        val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return weekForecast.size()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]) {
            holder.textview.text = "$date - $description - $high/$low"
        }
    }

    class ViewHolder(val textview: TextView) : RecyclerView.ViewHolder(textview)
}