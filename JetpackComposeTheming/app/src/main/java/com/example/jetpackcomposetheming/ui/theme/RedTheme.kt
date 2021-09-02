package com.example.jetpackcomposetheming.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkRedColorPalette = darkColors(
    primary = Red200,
    primaryVariant = Red700,
    secondary = Teal200,
    onPrimary = Color.White,
    onSecondary = Color.Black
)

private val LightRedColorPalette = lightColors(
    primary = Red500,
    primaryVariant = Red700,
    secondary = Blue200,
    onPrimary = Color.White,
    onSecondary = Color.Black

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)




@Composable
fun RedTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
   val colors = if (darkTheme) DarkRedColorPalette else LightRedColorPalette
    JetpackComposeThemingTheme(colors, content)
}