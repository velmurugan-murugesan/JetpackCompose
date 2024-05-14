package com.example.jetpackcomposetesting.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposetesting.ui.features.createProduct.CreateProduct
import com.example.jetpackcomposetesting.ui.features.home.HomeScreen
import com.example.jetpackcomposetesting.ui.features.splash.SplashScreen

@Composable
fun NavState(modifier: Modifier = Modifier, navController: NavHostController) {

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(modifier = modifier)
        }

        composable("home") {
            HomeScreen()
        }

        composable("createProduct") {
            CreateProduct()
        }


    }

}