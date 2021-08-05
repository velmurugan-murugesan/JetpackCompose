package com.velmurugan.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.velmurugan.jetpackcomposeexample.ui.HomeScreen
import com.velmurugan.jetpackcomposeexample.ui.Widgets
import com.velmurugan.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExampleTheme { // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    /*val movieList: List<Movie> by mainViewModel.movieResponse.observeAsState(listOf())
                    MovieList(movieList)
                    mainViewModel.getMovieDetails()*/
                    MainScreen()
                }
            }
        }
    }
}


@ExperimentalAnimationApi
@Composable
fun MainScreen() {

    val navController =  rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }

        composable("widgets") {
            Widgets()
        }

        composable("layouts") {

        }

    }

}



