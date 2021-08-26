package com.example.jetpackcomposelayouts.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun DisplayBoxLayout() {
    Box(modifier = Modifier
        .size(150.dp,150.dp)
        .background(Color.Green)) {
        Text(text = "Hello")
        Text(text = "jetpack compose")
    }
}

@Preview(showBackground = true)
@Composable
fun boxLayout() {
    Box(modifier = Modifier
        .size(150.dp,150.dp)
        .background(Color.Green)) {
        Text(text = "Hello", modifier = Modifier.align(Alignment.TopCenter))
        Text(text = "jetpack compose", modifier = Modifier.align(Alignment.BottomCenter))
    }
}