package com.example.weather.weather_ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.api.weather_api.NetworkResponse
import com.example.weather.api.weather_api.RetrofitInstance
import com.example.weather.api.weather_api.WeatherModel
import com.example.weather.util.Constant
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {

    private val weatherApi = RetrofitInstance.weatherApi

    private val _weatherResult = MutableLiveData<NetworkResponse<WeatherModel>>()
    val weatherResult : LiveData<NetworkResponse<WeatherModel>> = _weatherResult


    fun getData(city:String){
        _weatherResult.value = NetworkResponse.Loading
        viewModelScope.launch {
            try {
                val response =  weatherApi.getWeather(Constant.apiKey,city)
                if (response.isSuccessful){
                    response.body()?.let {
                        _weatherResult.value = NetworkResponse.Success(it)
                    }
                } else{
                    _weatherResult.value = NetworkResponse.Error("Failed")
                }
            } catch (e:Exception){
                _weatherResult.value = NetworkResponse.Error("Failed")
            }

        }
    }
}