package com.example.jetpackcomposelayouts.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(name = "", showBackground = true)
@Composable
fun DisplayTitle() {
    Column {
        Text(text = "Title Welcome")
        Text(text = "Jetpack compose")
    }
}

@Preview(showBackground = true)
@Composable
fun ArrangeTop() {
    Column(verticalArrangement = Arrangement.Top, modifier = Modifier.fillMaxWidth()
        .height(170.dp)
        .padding(8.dp)
        .border(2.dp, Color.Black)
        .padding(8.dp)) {
        Text(text = "Title Welcome")
        Text(text = "Jetpack compose")
    }
}

@Preview(showBackground = true)
@Composable
fun ArrangeCenter() {
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()
        .height(170.dp)
        .padding(8.dp)
        .border(2.dp, Color.Black)
        .padding(8.dp)) {
        Text(text = "Title Welcome")
        Text(text = "Jetpack compose")
    }
}

@Composable
fun ArrangeBottom() {
    Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier.fillMaxWidth()
        .height(170.dp)
        .padding(8.dp)
        .border(2.dp, Color.Black)
        .padding(8.dp)) {
        Text(text = "Title Welcome")
        Text(text = "Jetpack compose")
    }
}

@Composable
fun ArrangeSpaceAround() {
    Column(verticalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()
        .height(170.dp)
        .padding(8.dp)
        .border(2.dp, Color.Black)
        .padding(8.dp)) {
        Text(text = "Title Welcome")
        Text(text = "Jetpack compose")
    }
}


@Composable
fun ArrangeSpaceBetween() {
    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
        .height(170.dp)
        .padding(8.dp)
        .border(2.dp, Color.Black)
        .padding(8.dp)) {
        Text(text = "Title Welcome")
        Text(text = "Jetpack compose")
    }
}

@Composable
fun ArrangeSpaceEvenly() {
    Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()
        .height(170.dp)
        .padding(8.dp)
        .border(2.dp, Color.Black)
        .padding(8.dp)) {
        Text(text = "Title Welcome")
        Text(text = "Jetpack compose")
    }
}

@Composable
fun AlignStart() {
    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()
        .height(170.dp)
        .padding(8.dp)
        .border(2.dp, Color.Black)
        .padding(8.dp)) {
        Text(text = "Title Welcome")
        Text(text = "Jetpack compose")
    }
}

@Composable
fun AlignCenterHorizontally() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()
            .height(170.dp)
            .padding(8.dp)
            .border(2.dp, Color.Black)
            .padding(8.dp)
    ) {
        Text(text = "Title Welcome")
        Text(text = "Jetpack compose")
    }
}

@Composable
fun AlignEnd() {
    Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()
        .height(170.dp)
        .padding(8.dp)
        .border(2.dp, Color.Black)
        .padding(8.dp)) {
        Text(text = "Title Welcome")
        Text(text = "Jetpack compose")
    }
}












