package com.example.jetpackcomposemodifiers.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt


@Composable
fun ClickableModifier() {
    val context = LocalContext.current
    Text(
        text = "Hello Jetpack Compose", Modifier
            .clickable {
                Toast
                    .makeText(context, "Clicked", Toast.LENGTH_SHORT)
                    .show()
            }
            .padding(8.dp)
    )
}

@Composable
fun SelectableModifier() {
    var selected by remember {
        mutableStateOf(false)
    }
    val selectedColor = if (selected) Color.Black else Color.Gray
    Text(text = "Jetpack compose", color = selectedColor, modifier = Modifier
        .selectable(
            selected = selected, onClick = {
                selected = !selected
            }
        )
        .padding(8.dp))
}

@Composable
fun FocusableModifier() {
    val focusRequester = remember { FocusRequester() }
// MutableInteractionSource to track changes of the component's interactions (like "focused")
    val interactionSource = remember { MutableInteractionSource() }

// text below will change when we focus it via button click
    val isFocused = interactionSource.collectIsFocusedAsState().value
    val text = if (isFocused) {
        "Focused! tap anywhere to free the focus"
    } else {
        "Bring focus to me by tapping the button below!"
    }
    Column {
        // this Text will change it's text parameter depending on the presence of a focus
        Text(
            text = text,
            modifier = Modifier
                // add focusRequester modifier before the focusable (or even in the parent)
                .focusRequester(focusRequester)
                .focusable(interactionSource = interactionSource)
        )
        Button(onClick = { focusRequester.requestFocus() }) {
            Text("Bring focus to the text above")
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun SwipeableModifier() {
    val width = 320.dp
    val squareSize = 50.dp
    val barSize = 20.dp

    val swipeableState = rememberSwipeableState("A")
    val sizePx = with(LocalDensity.current) { (width - squareSize).toPx() }
    val anchors = mapOf(0f to "A", sizePx / 2 to "B", sizePx to "C")

    Column(Modifier.padding(20.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(squareSize)
                .swipeable(
                    state = swipeableState,
                    anchors = anchors,
                    thresholds = { _, _ -> FractionalThreshold(0.5f) },
                    orientation = Orientation.Horizontal
                )
        ) {

            Text(text = "",
                Modifier
                    .width(width)
                    .height(barSize)
                    .background(Color.Black, shape = CircleShape)
                    .align(Alignment.CenterStart))

            Box(
                Modifier
                    .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                    .size(squareSize)
                    .background(Color.Blue, shape = CircleShape), contentAlignment = Alignment.Center
            ) {
                Text(swipeableState.currentValue, color = Color.White, fontSize = 24.sp)
            }
        }
    }
}

@Composable
fun ScrollableModifierSample() {
    val offset = remember { mutableStateOf(0f) }
    Box(
        Modifier
            .size(150.dp)
            .scrollable(
                orientation = Orientation.Vertical,
                // state for Scrollable, describes how consume scroll amount
                state = rememberScrollableState { delta ->
                    offset.value = offset.value + delta // update the state
                    delta // indicate that we consumed all the pixels available
                }
            )
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(offset.value.roundToInt().toString(), style = TextStyle(fontSize = 32.sp))
    }
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun OnKeyEventModifier() {
    var name by remember {
        mutableStateOf("")
    }
    TextField(value = name, onValueChange = {name = it},
        Modifier.onKeyEvent {
            if (it.key.keyCode == Key.Enter.keyCode) {
                name = ""
            }
            return@onKeyEvent true
        })
}