package com.example.jetpackcomposemodifiers.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun BackgroundModifier() {
    Text(text = "Hello Jetpack Compose", Modifier.background(Color.Red))
}

@Composable
fun BackgroundWithShapeModifier() {
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(Color.Gray, Color.DarkGray),
        startX = 0.0f,
        endX = 500.0f
    )
    Text(text = "Hello Jetpack Compose", Modifier
        .padding(20.dp)
        .background(gradientBrush, CutCornerShape(8.dp), 1.0f)
        .padding(20.dp))
}

@Composable
fun BorderModifier() {
    Text(text = "Hello Jetpack Compose", Modifier
        .padding(20.dp)
        .border(4.dp, Color.DarkGray)
        .padding(20.dp))
}

@Composable
fun BorderWithBrush() {
    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(Color.Red, Color.Blue, Color.Green),
        startX = 0.0f,
        endX = 500.0f,
        tileMode = TileMode.Repeated
    )
    Text(
        "Hello Jetpack Compose",
        modifier = Modifier
            .padding(10.dp)
            .border(width = 2.dp, brush = gradientBrush, shape = CircleShape)
            .padding(10.dp)
    )
}
@Composable
fun ClipModifier() {
    Text(
        "Hello Jetpack Compose",
        modifier = Modifier
            .padding(10.dp)
            .clip(RectangleShape)
            .background(Color.Gray)
            .padding(10.dp)
    )
}

@Composable
fun AlphaModifier() {
    Text(
        "Hello Jetpack Compose",
        modifier = Modifier
            .padding(10.dp)
            .alpha(0.5f)
            .background(Color.Gray)
            .padding(10.dp)
    )
}

@Composable
fun RotateModifier() {
    Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            "Hello Jetpack Compose",
            modifier = Modifier
                .padding(10.dp)
                .rotate(45f)
                .background(Color.Gray)
                .padding(10.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun ShadowModifier() {
    Text(
        "Hello Jetpack Compose",
        modifier = Modifier
            .padding(10.dp)
            .shadow(4.dp, CircleShape)
            .padding(10.dp)
    )
}

