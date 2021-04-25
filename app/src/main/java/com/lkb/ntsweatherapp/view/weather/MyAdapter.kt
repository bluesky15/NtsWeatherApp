package com.lkb.ntsweatherapp.view.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lkb.ntsweatherapp.R

class MyAdapter() : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    interface OnItemClickListener {
        fun onCityClicked(city: String)
    }

    private var listener: OnItemClickListener? = null
    private var mListData: List<String> = listOf(
        "Pune",
        "Bengaluru",
        "Kolkata",
        "Goa",
        "Chennai",
        "Bhubaneswar",
        "Puri",
        "Visakhapatnam"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_forecast_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mListData.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mDayTxt.rootView.setOnClickListener {
            listener?.onCityClicked(holder.mDayTxt.text.toString())
        }
        holder.mDayTxt.text = mListData[position]
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mDayTxt: TextView = itemView.findViewById(R.id.txtDay)
    }

    fun setListenerInstance(listener: OnItemClickListener) {
        this.listener = listener
    }


}