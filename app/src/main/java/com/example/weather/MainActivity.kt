package com.example.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.widget.TextView
import com.example.weather.repository.WeatherRepository

class MainActivity : AppCompatActivity() {
    private val weatherRepository = WeatherRepository()
    private val apiKey = "YOUR_API_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cityName = "Jakarta"
        val weatherInfoTextView: TextView = findViewById(R.id.weatherInfoTextView)

        weatherRepository.getWeather(cityName, apiKey) { weatherResponse ->
            if (weatherResponse != null) {
                val weatherInfo = """
                    City: ${weatherResponse.name}
                    Temperature: ${weatherResponse.main.temp} °C
                    Description: ${weatherResponse.weather[0].description}
                """.trimIndent()
                weatherInfoTextView.text = weatherInfo
            } else {
                weatherInfoTextView.text = "Failed to retrieve weather information."
            }
        }
    }
}