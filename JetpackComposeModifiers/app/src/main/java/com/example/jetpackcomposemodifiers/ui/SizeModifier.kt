package com.example.jetpackcomposemodifiers.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SizeModifier() {
    Text(text = "Jetpack Padding", Modifier.size(30.dp))
}

@Composable
fun SizeWidthHeightModifier() {
    Text(text = "Jetpack Padding", Modifier.size(150.dp, 30.dp))
}

@Composable
fun fillMaxSize() {
    Text(text = "Jetpack Padding", Modifier.fillMaxSize())
}





@Composable
fun PaddingAllSide() {
    Text(text = "Jetpack Padding", Modifier.padding(30.dp,10.dp,30.dp,10.dp))
}

@Composable
fun PaddingVerticalAndHorizontal() {
    Text(text = "Jetpack Padding", Modifier.padding(30.dp,10.dp))
}

@Composable
fun PaddingAll() {
    Text(text = "Jetpack Padding", Modifier.padding(30.dp))
}

@Composable
fun AspectRatio() {
    Text(text = "Compose AspectRatio", Modifier.aspectRatio(2f))
}

@Composable
fun ScaleAll() {
    Box(Modifier.size(200.dp)) {
        Text(text = "Compose Scale", Modifier
            .background(Color.Gray)
            .scale(2f))
    }
}

@Composable
fun ScaleAxis() {
    Box(Modifier.size(200.dp)) {
        Text(text = "Compose Scale", Modifier
            .background(Color.Gray)
            .scale(1f, 2f))
    }
}

