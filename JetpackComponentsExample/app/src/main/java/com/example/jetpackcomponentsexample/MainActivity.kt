package com.example.jetpackcomponentsexample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentsexample.theme.AppTheme


class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    DisplayAnnotatedString()
                    DisplayTextField()
                    DisplayOutlinedTextField()
                    DisplayPrimaryButton()
                    DisplayOutlinedButton()
                    DisplayCheckBox()
                    DisplayRadioButton()
                    DisplaySurface()
                    DisplayCircularProgressBar()
                    DisplayLinearProgressBar()
                    DisplaySwitch()
                    DisplaySlider()
                    DisplaySliderWithStepper()
                }
            }
        }

}
@Preview(showBackground = true)
@Composable
fun DisplaySpacer() {
    Spacer(modifier = Modifier
        .padding(8.dp)
        .height(40.dp)
        .fillMaxWidth()
        .background(Color.Gray))
}

@Composable
fun DisplaySliderWithStepper() {
    var sliderValue by remember {
        mutableStateOf(25.0f)
    }
    Text(text = sliderValue.toInt().toString(), modifier = Modifier.fillMaxWidth(),textAlign = TextAlign.Center)
    Slider(value = sliderValue, onValueChange = {sliderValue = it}, steps = 3, valueRange = 0f..100f)
}

@Composable
fun DisplaySlider() {
    Spacer(modifier = Modifier.padding(4.dp))
    var sliderValue by remember {
        mutableStateOf(10.0f)
    }
    Text(text = sliderValue.toInt().toString(), modifier = Modifier.fillMaxWidth(),textAlign = TextAlign.Center)
    Slider(value = sliderValue, onValueChange = {sliderValue = it}, valueRange = 0f..100f)
}
@Composable
fun DisplaySwitch() {
    val context = LocalContext.current
    var switchStatus by remember {
        mutableStateOf(false)
    }
    Row(Modifier.padding(8.dp)) {
        Text(text = "Light on/off")
        Switch(checked = switchStatus, onCheckedChange = {
            switchStatus = it
            Toast.makeText(context, "Light ${if (it) "on" else "off"}", Toast.LENGTH_SHORT).show() })
    }
}
@Composable
fun DisplayLinearProgressBar() {
    LinearProgressIndicator(progress = 0.5f, backgroundColor = Color.Blue, color = Color.Black, modifier = Modifier.padding(4.dp))
}
@Composable
fun DisplayCircularProgressBar() {
        CircularProgressIndicator(progress = 0.5f, strokeWidth = 8.dp, color = Color.Gray, modifier = Modifier.padding(4.dp))
}

@ExperimentalMaterialApi
@Composable
fun DisplaySurface() {
    val context = LocalContext.current
    Surface(shape = RoundedCornerShape(8.dp), elevation = 8.dp, onClick = {
        Toast.makeText(
            context,
            "Surface clicked",
            Toast.LENGTH_SHORT
        ).show()},border = BorderStroke(2.dp, Color.Blue), modifier = Modifier
        .padding(8.dp)
        .width(100.dp)) {
        Text(text = "Surface",Modifier.padding(8.dp), textAlign = TextAlign.Center)
    }
}

@Composable
fun DisplayCheckBox() {
    var checkStatus by remember {
        mutableStateOf(false)
    }
    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = checkStatus, onCheckedChange = {
            checkStatus = it
        })

        Text(text = "Checkbox", Modifier.clickable { checkStatus = !checkStatus })
    }
}

@Composable
fun DisplayRadioButton() {
    val cities = listOf("Chennai", "Mumbai", "Pune")
    val (selected, onOptionSelected) = remember {
        mutableStateOf(cities[0])
    }
    Column(Modifier.padding(4.dp)) {
        cities.forEach { text ->
            Row(modifier = Modifier.padding(4.dp)) {
                RadioButton(selected = selected == text, onClick = {
                    onOptionSelected(text)
                })
                Text(text = text, Modifier.clickable { onOptionSelected(text) })
            }
        }
    }
}

@Composable
fun DisplayPrimaryButton() {
    val context = LocalContext.current
    Button(onClick = {
        Toast.makeText(context, "Primary Button clicked", Toast.LENGTH_SHORT).show()
    }, Modifier.padding(4.dp)) {
        Text(
            text = "Primary Button",
            style = TextStyle(fontSize = 22.sp,fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
        )
    }
}

@Composable
fun DisplayOutlinedButton() {
    val context = LocalContext.current
    OutlinedButton(onClick = {
        Toast.makeText(
            context,
            "Outlined Button clicked",
            Toast.LENGTH_SHORT
        ).show()
    }, Modifier.padding(4.dp)) {
        Text(
            text = "Outlined Button",
            style = TextStyle(fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
        )
    }
}

@Composable
fun DisplayTextField() {
    var password by remember {
        mutableStateOf("Hello")
    }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Enter password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
fun DisplayOutlinedTextField() {
    var name by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = name, onValueChange = { it ->
        name = it
    }, label = { Text(text = "Username") })
}

@Composable
fun SimpleText() {
    Column {
        Text(text = stringResource(R.string.hello_world), fontSize = 20.sp)
        Text(text = stringResource(R.string.hello_world), fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = stringResource(R.string.hello_world), fontSize = 20.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)
        Text(text = stringResource(R.string.hello_world), fontSize = 20.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic , fontFamily = FontFamily.Monospace)

    }

}

@Composable
fun DisplayAnnotatedString() {
    val context = LocalContext.current
    Text(buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Gray)) {
            append("Text")
        }
        append(" Jetpack")

        withStyle(style = SpanStyle(color = Color.Red, fontFamily = FontFamily.Monospace)) {
            append(" compose")
        }
    })
}









