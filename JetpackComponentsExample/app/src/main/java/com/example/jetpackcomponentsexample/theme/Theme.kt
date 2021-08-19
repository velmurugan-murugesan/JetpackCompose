package com.example.jetpackcomponentsexample.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

val lightColor = lightColors(
    primary = green500, primaryVariant = green700,secondary = green200
)

@Composable
fun AppTheme(content: @Composable() () -> Unit) {

    MaterialTheme(
        colors = lightColor, typography = Typography, content = content
    )
}