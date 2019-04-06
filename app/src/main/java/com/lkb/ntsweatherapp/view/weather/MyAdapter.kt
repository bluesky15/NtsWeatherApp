package com.lkb.ntsweatherapp.view.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lkb.ntsweatherapp.R
import com.lkb.ntsweatherapp.model.WeatherModel

import java.text.SimpleDateFormat

class MyAdapter() : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var mListData: List<WeatherModel.Forecastday> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_forecast_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mListData.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pattern = "yyyy-mm-dd"
        val simpleDateFormat = SimpleDateFormat(pattern)
        val date = simpleDateFormat.parse(mListData[position].date)
        holder.mDayTxt.text = date.toString().split(" ")[0]
        holder.mTempTxt.text = mListData[position].day.maxtemp_c.toString()
    }

    fun bindData(data: WeatherModel.WeatherApiResponse) {
        mListData = data.forecast.forecastday
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mDayTxt: TextView = itemView.findViewById(R.id.txtDay)
        var mTempTxt: TextView = itemView.findViewById(R.id.txtTemp)
    }


}