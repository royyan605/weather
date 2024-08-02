package com.example.weather.model

data class WeatherResponse(
    val main: Main,
    val name: String,
    val weather: List<Weather>
)

data class Main(
    val temp: Float,
    val pressure: Int,
    val humidity: Int
)

data class Weather(
    val description: String,
    val icon: String
)