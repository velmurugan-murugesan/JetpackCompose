package com.example.jetpackcomposetesting.ui.features.splash

import android.window.SplashScreen
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Splash Screen")
    }
}