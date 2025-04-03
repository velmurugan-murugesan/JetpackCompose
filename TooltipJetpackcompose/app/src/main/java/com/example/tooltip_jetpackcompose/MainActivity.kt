package com.example.tooltip_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.RichTooltip
import androidx.compose.material3.RichTooltipColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tooltip_jetpackcompose.ui.theme.TooltipJetpackComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TooltipJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val scope = rememberCoroutineScope()

                    val richTooltipState = rememberTooltipState()
                    Column(
                        Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        PlainTooltip()

                        Spacer(Modifier.height(50.dp))

                        RichTooltip()

                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RichTooltip(modifier: Modifier = Modifier) {

    val scope = rememberCoroutineScope()
    val richTooltipState = rememberTooltipState()

    TooltipBox(
        positionProvider = TooltipDefaults.rememberRichTooltipPositionProvider(),
        tooltip = {
            RichTooltip(
                title = {
                    Text("Rich Tooltip")
                },
                text = {
                    // 50 char text
                    Text("A rich tooltip can contain formatted text, images, buttons, or other interactive elements.")
                },
                action = {
                    IconButton(onClick = {
                        scope.launch {
                            richTooltipState.dismiss()
                        }
                    }
                    ) {
                        Text("Close")
                    }

                })
        },
        state = richTooltipState
    )
    {
        Button(onClick = {
            scope.launch {
                richTooltipState.show()
            }

        }) {
            Text("Show Rich Tooltip")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlainTooltip() {
    val scope = rememberCoroutineScope()
    val plainTooltipState = rememberTooltipState()
    TooltipBox(
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
        tooltip = {
            PlainTooltip {
                Text("A plain tooltip is a simple text tooltip that appears when a user")
            }
        },
        state = plainTooltipState
    ) {
        Button(onClick = {
            scope.launch {
                plainTooltipState.show()
            }

        }) {
            Text("Show Plain Tooltip")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TooltipJetpackComposeTheme {
        Greeting("Android")
    }
}