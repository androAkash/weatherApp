package com.example.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.weather.ui.theme.WeatherTheme
import com.example.weather.weather_ui.WeatherScreen
import com.example.weather.weather_ui.WeatherViewModel

//25/05/2024 Akash Bhattacharya's Weather app

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
        setContent {
            WeatherTheme {
                WeatherScreen(viewModel = weatherViewModel)
            }
        }
    }
}
