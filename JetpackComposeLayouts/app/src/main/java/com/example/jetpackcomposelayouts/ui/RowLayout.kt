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

@Preview(showBackground = true)
@Composable
fun DisplayRowLayout() {
    Row(Modifier.fillMaxWidth()
        .height(150.dp)
        .padding(8.dp).border(2.dp, Color.Blue).padding(8.dp), verticalAlignment = Alignment.Bottom) {
        Text(text = "Title Welcome", Modifier.padding(8.dp).border(1.dp, Color.Black))
        Text(text = "Jetpack compose", Modifier.padding(8.dp).border(1.dp, Color.Black))
    }
}

@Composable
fun RowArrangeCenter() {
    Row(Modifier.fillMaxWidth()
        .height(150.dp)
        .padding(8.dp).border(2.dp, Color.Blue).padding(8.dp), horizontalArrangement = Arrangement.Center) {
        Text(text = "Title Welcome", Modifier.padding(8.dp).border(1.dp, Color.Black))
        Text(text = "Jetpack compose", Modifier.padding(8.dp).border(1.dp, Color.Black))
    }
}

@Composable
fun RowArrangeEnd() {
    Row(Modifier.fillMaxWidth()
        .height(150.dp)
        .padding(8.dp).border(2.dp, Color.Blue).padding(8.dp), horizontalArrangement = Arrangement.End) {
        Text(text = "Title Welcome", Modifier.padding(8.dp).border(1.dp, Color.Black))
        Text(text = "Jetpack compose", Modifier.padding(8.dp).border(1.dp, Color.Black))
    }
}

@Composable
fun RowArrangeSpaceAround() {
    Row(Modifier.fillMaxWidth()
        .height(150.dp)
        .padding(8.dp).border(2.dp, Color.Blue).padding(8.dp), horizontalArrangement = Arrangement.SpaceAround) {
        Text(text = "Title Welcome", Modifier.padding(8.dp).border(1.dp, Color.Black))
        Text(text = "Jetpack compose", Modifier.padding(8.dp).border(1.dp, Color.Black))
    }
}

@Composable
fun RowArrangeSpaceBetween() {
    Row(Modifier.fillMaxWidth()
        .height(150.dp)
        .padding(8.dp).border(2.dp, Color.Blue).padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Title Welcome", Modifier.padding(8.dp).border(1.dp, Color.Black))
        Text(text = "Jetpack compose", Modifier.padding(8.dp).border(1.dp, Color.Black))
    }
}

@Composable
fun RowArrangeSpaceEvenly() {
    Row(Modifier.fillMaxWidth()
        .height(150.dp)
        .padding(8.dp).border(2.dp, Color.Blue).padding(8.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
        Text(text = "Title Welcome", Modifier.padding(8.dp).border(1.dp, Color.Black))
        Text(text = "Jetpack compose", Modifier.padding(8.dp).border(1.dp, Color.Black))
    }
}











