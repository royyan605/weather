package com.example.weather.repository

import com.example.weather.NetworkModule
import com.example.weather.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository {
    private val weatherApi = NetworkModule.provideWeatherApi(NetworkModule.provideRetrofit())

    fun getWeather(cityName: String, apiKey: String, callback: (WeatherResponse?) -> Unit) {
        weatherApi.getWeather(cityName, apiKey).enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    callback(response.body())
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                callback(null)
            }
        })
    }
}