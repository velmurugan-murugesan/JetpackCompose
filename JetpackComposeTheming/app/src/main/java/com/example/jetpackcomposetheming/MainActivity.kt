package com.example.jetpackcomposetheming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.jetpackcomposetheming.ui.theme.*
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsPadding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val themeType = remember {
                mutableStateOf(ThemeType.PURPLE)
            }

            val isDarkMode = remember {
                mutableStateOf(false)
            }


            val themeFunction: @Composable (isDarkMode: Boolean, content: @Composable () -> Unit) -> Unit =
                when (themeType.value) {

                    ThemeType.PURPLE -> { isDarkMode, content -> PurpleTheme(isDarkMode, content) }

                    ThemeType.RED -> { isDarkMode, content -> RedTheme(isDarkMode, content) }

                    ThemeType.YELLOW -> { isDarkMode, content -> YellowTheme(isDarkMode, content) }

                }


            themeFunction.invoke(isDarkMode.value) {
                AllView(darkMode = isDarkMode, themeType = themeType)
            }
        }
    }

}

@Composable
fun AllView(darkMode: MutableState<Boolean>, themeType: MutableState<ThemeType>) {
    ProvideWindowInsets {
        Scaffold(
            topBar = { AppToolBar(themeType) },
            content = { MainContent(darkMode, themeType) }
        )
    }

}


@Composable
fun AppToolBar(themeType: MutableState<ThemeType>) {



        TopAppBar(
            title = {
                Text(text = "Theming Jetpack compose", modifier = Modifier.clickable {
                    themeType.value = ThemeType.RED
                })
            },
            backgroundColor = MaterialTheme.colors.primary,

            modifier = Modifier
                .background(MaterialTheme.colors.primaryVariant)
                .fillMaxWidth()
                .statusBarsPadding()

            )
    }




@Composable
fun MainContent(darkMode: MutableState<Boolean>, themeType: MutableState<ThemeType>) {

    Column() {

        DarKModeButton(darkMode)
        ThemeButton(themeType)
        ButtonUI(color = MaterialTheme.colors.primary, text = "Primary")
        ButtonUI(color = MaterialTheme.colors.primaryVariant, text = "Primary Variant")
        ButtonUI(color = MaterialTheme.colors.secondary, text = "Secondary")

    }

}

@Composable
fun DarKModeButton(darkMode: MutableState<Boolean>) {

    Surface(Modifier.padding(10.dp)) {

        Row {
            Checkbox(checked = darkMode.value, onCheckedChange = {
                darkMode.value = !darkMode.value
            })

            Text(text = "Dark Mode")
        }

    }


}

@Composable
fun ThemeButton(themeType: MutableState<ThemeType>) {
    Surface(Modifier.padding(10.dp)) {
        Column {
            Text(text = "Theme")
            Spacer(modifier = Modifier.padding(0.dp,10.dp))
            Row {

                RadioButton(selected = themeType.value == ThemeType.PURPLE, onClick = {
                    themeType.value = ThemeType.PURPLE
                })
                Text(text = "Purple")
                Spacer(modifier = Modifier.padding(10.dp, 0.dp))


                RadioButton(selected = themeType.value == ThemeType.RED, onClick = {
                    themeType.value = ThemeType.RED
                })
                Text(text = "Red")
                Spacer(modifier = Modifier.padding(10.dp, 0.dp))

                RadioButton(selected = themeType.value == ThemeType.YELLOW, onClick = {
                    themeType.value = ThemeType.YELLOW
                })
                Text(text = "Yellow")
            }
        }


    }
}

@Composable
fun ButtonUI(color: Color, text: String) {
    Surface(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(100.dp),
        shape = MaterialTheme.shapes.medium,
        color = color
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text, fontSize = 20.sp, fontWeight = FontWeight.Bold,fontFamily = FontFamily.Monospace)
        }

    }
}


@Composable
fun TypographyPreview() {

    Column(
        Modifier
            .width(400.dp)
            .padding(10.dp)) {
        Text(text = "H2 " ,style = MaterialTheme.typography.h2)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = "Subtitle 1 " ,style = MaterialTheme.typography.subtitle1)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = "Body 1 " ,style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = "Button " ,style = MaterialTheme.typography.button)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = "Caption " ,style = MaterialTheme.typography.caption)

    }

}
@Preview(showBackground = true)
@Composable
fun ShapePreview() {
    Column(
        Modifier
            .width(400.dp)
            .padding(10.dp)) {
        Button(onClick = { }, shape = Shapes.small) {
            Text(text = "Round Corner Shape")
        }
        Spacer(modifier = Modifier.padding(4.dp))

        Button(onClick = { }, shape = Shapes.medium) {
            Text(text = "Cut Corner Shape")
        }

    }
}