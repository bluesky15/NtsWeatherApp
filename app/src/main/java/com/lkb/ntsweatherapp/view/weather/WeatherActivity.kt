package com.lkb.ntsweatherapp.view.weather

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.ViewModelProviders
import com.lkb.ntsweatherapp.Constants
import com.lkb.ntsweatherapp.R
import com.lkb.ntsweatherapp.model.WeatherModel
import com.lkb.ntsweatherapp.view.common.BaseActivity
import com.lkb.ntsweatherapp.viewmodel.ViewModelFactory
import com.lkb.ntsweatherapp.viewmodel.weather.WeatherViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.weather_main.*
import javax.inject.Inject

class WeatherActivity : BaseActivity() {

    @Inject
    lateinit var adapter: MyAdapter

    @Inject
    lateinit var mViewModelFactory: ViewModelFactory

    private lateinit var mViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPresentationComponent().inject(this)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.weather_main)
        recycler.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
            this,
            androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,
            false
        )
        recycler.adapter = adapter
    }


    override fun onStart() {
        super.onStart()
        mViewModel = ViewModelProviders.of(this,mViewModelFactory)
            .get(WeatherViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        bindWeatherData()

    }

    private fun bindWeatherData() {
        if (mViewModel.mWeatherData == null) {
            mViewModel.callWeatherApi(Constants.WEATHER_API_KEY, "Bangalore", 7)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe {
                    adapter.bindData(it)
                    mViewModel!!.mWeatherData = it
                    initUi(it)
                }
        } else {
            adapter.bindData(mViewModel.mWeatherData!!)
            initUi(mViewModel.mWeatherData!!)
        }
    }
    private fun initUi(data: WeatherModel.WeatherApiResponse) {
        temparatureTxt.text = data.current.temp_c.toString()
        locationTxt.text = data.location.name
        progressBar.visibility = View.GONE
        locationTxt.visibility = View.VISIBLE
        temparatureTxt.visibility = View.VISIBLE
        degreeImage.visibility = View.VISIBLE
    }

}