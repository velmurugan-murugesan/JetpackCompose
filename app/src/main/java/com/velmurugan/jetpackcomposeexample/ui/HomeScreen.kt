package com.velmurugan.jetpackcomposeexample.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Button(onClick = { navController.navigate("recyclerview")} , Modifier.padding(8.dp)) {
            Text(text = "Recyclerview in Compose")
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Button(onClick = {navController.navigate("widgets")} , Modifier.padding(8.dp)) {
            Text(text = "Widgets in Compose")
        }
        Spacer(modifier = Modifier.padding(4.dp))

        Button(onClick = { navController.navigate("layouts") }) {
            Text(text = "Layouts")
        }
        Spacer(modifier = Modifier.padding(4.dp))

    }
}
