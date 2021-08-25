package com.example.jetpackcomposemodifiers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.CombinedModifier
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposemodifiers.ui.*
import com.example.jetpackcomposemodifiers.ui.theme.JetpackComposeModifiersTheme

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeModifiersTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    OnKeyEventModifier()
                }
            }
        }
    }
}

@Composable
fun DisplayMessage() {
    Text(
        text = "Hello World!", modifier = Modifier
            .size(200.dp, 100.dp)
            .background(Color.Gray)
            .padding(10.dp)
    )
}

@Composable
fun CombinedModifier() {
    Text(
        text = "Jetpack compose", modifier = Modifier
            .size(200.dp, 100.dp)
            .background(Color.Black)
            .padding(10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PaddingModifier() {
    Text(
        text = "Hello compose",
        modifier = Modifier
            .background(Color.White)
            .padding(30.dp, 10.dp, 30.dp, 10.dp)
    )
}




