package com.example.jetpackcomposeconstraintlayout

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.solver.state.helpers.GuidelineReference
import androidx.constraintlayout.widget.Guideline
import com.example.jetpackcomposeconstraintlayout.ui.theme.JetpackComposeConstraintLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeConstraintLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ConstraintLayoutGuideLine()
                }
            }
        }
    }
}
@Composable
fun ConstraintLayoutLinkToParentExample() {

    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)) {

        val (textTopStart, textTopCenter, textTopEnd, textCenterStart,textCenter, textCenterEnd, textBottomStart, textBottomCenter, textBottomEnd) = createRefs()

        Text(text = "Top start", Modifier.constrainAs(textTopStart) {
            top.linkTo(parent.top, 8.dp)
            start.linkTo(parent.start, 8.dp)
        })

        Text(text = "Top Center", Modifier.constrainAs(textTopCenter) {
            top.linkTo(parent.top, 8.dp)
            start.linkTo(parent.start, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })

        Text(text = "Top End", Modifier.constrainAs(textTopEnd) {
            top.linkTo(parent.top, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })

        Text(text = "Center start", Modifier.constrainAs(textCenterStart) {
            top.linkTo(parent.top, 8.dp)
            bottom.linkTo(parent.bottom, 8.dp)
        })

        Text(text = "Center", Modifier.constrainAs(textCenter) {
            top.linkTo(parent.top, 8.dp)
            bottom.linkTo(parent.bottom, 8.dp)
            start.linkTo(parent.start, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })

        Text(text = "Center end", Modifier.constrainAs(textCenterEnd) {
            top.linkTo(parent.top, 8.dp)
            bottom.linkTo(parent.bottom, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })


        Text(text = "Bottom start", Modifier.constrainAs(textBottomStart) {
            start.linkTo(parent.start, 8.dp)
            bottom.linkTo(parent.bottom, 8.dp)
        })

        Text(text = "Bottom Center", Modifier.constrainAs(textBottomCenter) {
            bottom.linkTo(parent.bottom, 8.dp)
            start.linkTo(parent.start, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })

        Text(text = "Bottom end", Modifier.constrainAs(textBottomEnd) {
            bottom.linkTo(parent.bottom, 8.dp)
            end.linkTo(parent.end, 8.dp)
        })
    }
}

@Composable
fun ConstraintSetExample() {

    val constraintSet = ConstraintSet {
        val buttonLogin = createRefFor("buttonLogin")
        val inputUsername = createRefFor("inputUsername")
        val inputPassword = createRefFor("inputPassword")

        constrain(inputUsername) {
            top.linkTo(parent.top, 32.dp)
            start.linkTo(parent.start, 16.dp)
            end.linkTo(parent.end, 16.dp)
        }

        constrain(inputPassword) {
            top.linkTo(inputUsername.bottom, 8.dp)
            start.linkTo(parent.start, 16.dp)
            end.linkTo(parent.end, 16.dp)
        }

        constrain(buttonLogin) {
            top.linkTo(inputPassword.bottom, 16.dp)
            start.linkTo(parent.start, 16.dp)
            end.linkTo(parent.end, 16.dp)
        }

    }

    ConstraintLayout(constraintSet, modifier = Modifier
        .fillMaxWidth()
        .height(250.dp)) {
        val context = LocalContext.current
        var username by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        TextField(value = username,  onValueChange = { username = it } , label = { Text(text = ("Username"))},  modifier =  Modifier.layoutId("inputUsername"))

        TextField(value = password, onValueChange = { password = it }, label = { Text("Password")},        visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.layoutId("inputPassword"))

        Button(onClick = { Toast.makeText(context, "Username $username , Password: $password ", Toast.LENGTH_SHORT).show()}, Modifier.layoutId("buttonLogin")) {
            Text(text = "Login")
        }
    }

}

@Composable
fun ConstraintLayoutGuideLine() {

    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(12.dp)) {

        val (input) = createRefs()
        val guildLineFromTop = createGuidelineFromTop(0.2f)
        val guildLineFromStart = createGuidelineFromStart(50.dp)

        Text(text = "GuildLine From top and start", modifier = Modifier.constrainAs(input) {
            top.linkTo(guildLineFromTop, 8.dp)
            start.linkTo(guildLineFromStart, 8.dp)
        } )
    }
}

@Composable
fun BarrierExample() {
    ConstraintLayout(modifier = Modifier
        .width(300.dp)
        .padding(12.dp)) {
        val (input1, input2, input3) = createRefs()

        val barrier = createEndBarrier(input1, input2)

        Text(text = "Iuput 1 Large", modifier = Modifier.constrainAs(input1) {
            top.linkTo(parent.top, 8.dp)
            start.linkTo(parent.start, 8.dp)
        } )

        Text(text = "Iuput 2", modifier = Modifier.constrainAs(input2) {
            top.linkTo(input1.bottom, 8.dp)
            start.linkTo(parent.start, 8.dp)
        } )

        Text(text = "Iuput 3", modifier = Modifier.constrainAs(input3) {
            top.linkTo(input1.bottom, 8.dp)
            start.linkTo(barrier, 8.dp)
        } )
    }
}

@Preview(showBackground = true)
@Composable
fun ChainExample() {
    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)) {
        val (button1, button2, button3) = createRefs()

        createHorizontalChain(button1, button2, button3, chainStyle = ChainStyle.Packed)


        Button(onClick = { }, modifier = Modifier.constrainAs(button1) {
            centerHorizontallyTo(parent)
        }) {
            Text(text = "Button 1")
        }

        Button(onClick = { }, modifier = Modifier.constrainAs(button2) {
            centerVerticallyTo(parent)
        }) {
            Text(text = "Button 2")
        }

        Button(onClick = { }, modifier = Modifier.constrainAs(button3) {
            centerHorizontallyTo(parent)
        }) {
            Text(text = "Button 3")
        }
    }
}



