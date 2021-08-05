package com.velmurugan.jetpackcomposeexample.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.velmurugan.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme


@Composable
fun Widgets() {

    val mContext = LocalContext.current

    Column {

        Text(text = "Text Field")

        Spacer(modifier = Modifier.padding(4.dp))

        Button(onClick = {
            Toast.makeText(mContext, "Button Clicked", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Button")
        }
        Spacer(modifier = Modifier.padding(4.dp))

        var inputData by remember {
            mutableStateOf("")
        }

        TextField(
            value = inputData,
            onValueChange = { inputData = it },
            label = { Text("Enter Username") }
        )

        var isChecked by remember {
            mutableStateOf(false)
        }

        Row {
            Checkbox(checked = isChecked, onCheckedChange = { isChecked = it})
            Text(text = "CheckBox", Modifier.padding(4.dp, 0.dp))
        }


        var selectedGender by remember {
            mutableStateOf("Male")
        }
        Row {
            RadioButton(selected = selectedGender == "Male", onClick = {
                selectedGender = "Male"
            })
            Text(text = "Male", Modifier.padding(4.dp, 0.dp))

            RadioButton(selected = selectedGender == "Female", onClick = {
                selectedGender = "Female"
            }, Modifier.padding(8.dp, 0.dp, 0.dp,0.dp))
            Text(text = "Female", Modifier.padding(4.dp, 0.dp))
        }

        val progressValue by remember {
            mutableStateOf(30.toFloat())
        }

        CircularProgressIndicator( progress = progressValue)

        var ageSlider by remember {
            mutableStateOf(0.toFloat())
        }

        Slider(value = ageSlider, onValueChange = {ageSlider = it})

        Slider(value = ageSlider, onValueChange = {ageSlider = it},
        steps = 6, valueRange = 0f..100f)

        var switchStatus by remember {
            mutableStateOf(false)
        }
        Row {
            Text(text = "Slide Mode")
            Switch(checked = switchStatus, onCheckedChange = {switchStatus = it}, Modifier.padding(4.dp, 0.dp))
        }

    }

}


@Preview (showBackground = true)
@Composable
fun WidgetsPreview() {

    JetpackComposeExampleTheme {
        Widgets()
    }
}