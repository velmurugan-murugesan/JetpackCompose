package com.example.jetpackcomposetheming.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val DarkYellowColorPalette = darkColors(
    primary = Yellow200,
    primaryVariant = Yellow700,
    secondary = Orange200,
    onPrimary = Color.White,
    onSecondary = Color.Black
)

private val LightYellowColorPalette = lightColors(
    primary = Yellow500,
    primaryVariant = Yellow700,
    secondary = Orange200,
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
fun YellowTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) DarkYellowColorPalette else LightYellowColorPalette
    JetpackComposeThemingTheme(colors, content)
}