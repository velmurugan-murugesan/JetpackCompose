package com.example.jetpackcomposetheming.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable




enum class ThemeType {
    PURPLE,
    RED,
    YELLOW
}


@Composable
fun JetpackComposeThemingTheme(
    colors: Colors,
    content: @Composable() () -> Unit
) {


    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}


