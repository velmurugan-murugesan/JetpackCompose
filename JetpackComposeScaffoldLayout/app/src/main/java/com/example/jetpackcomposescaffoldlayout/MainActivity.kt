package com.example.jetpackcomposescaffoldlayout

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposescaffoldlayout.ui.theme.JetpackComposeScaffoldLayoutTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeScaffoldLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    var toolbarTitle by remember {
                        mutableStateOf("Home")
                    }
                    val scaffoldState =
                        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
                    val scope = rememberCoroutineScope()

                    Scaffold(
                        modifier = Modifier.background(Color.White),
                        scaffoldState = scaffoldState,
                        topBar = {
                            AppToolbar(
                                scaffoldState = scaffoldState,
                                scope = scope,
                                toolbarTitle = toolbarTitle
                            )
                        }, drawerContent = {
                            DrawerContent(scaffoldState = scaffoldState, scope = scope)
                        },
                        content = {},
                        bottomBar = { BottomAppBar() },
                        snackbarHost = { state -> MySnackHost(state) },
                        isFloatingActionButtonDocked = true,
                        floatingActionButtonPosition = FabPosition.Center,
                        floatingActionButton = { FloatingActionButtonSample(scaffoldState) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarSample() {
    val scaffoldState =
        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    AppToolbar(scaffoldState = scaffoldState, scope = scope, toolbarTitle = "Home")
}

@Composable
fun AppToolbar(scaffoldState: ScaffoldState, scope: CoroutineScope, toolbarTitle: String) {
    TopAppBar(
        title = { Text(text = toolbarTitle) },
        modifier = Modifier.background(Color(0xFF008800)),
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                contentDescription = "Menu", modifier = Modifier.clickable {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        actions = {
            val context = LocalContext.current
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_settings_24),
                contentDescription = "Setting", modifier = Modifier.clickable {
                    Toast.makeText(context, "Open Setting", Toast.LENGTH_SHORT).show()
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DrawerContentSample() {
    val scaffoldState =
        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    DrawerContent(scaffoldState,scope)
}

@Composable
fun DrawerContent(scaffoldState: ScaffoldState, scope: CoroutineScope) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_face_24),
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally), contentDescription = "Face"
        )

        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "Velmurugan",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            )
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = "User1",
            Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(8.dp, 4.dp)
                .clickable {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                })
        Spacer(modifier = Modifier.padding(4.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun BottomAppBar() {
    data class MenuItem(val title: String, val icon: ImageVector)

    fun getMenuList() : List<MenuItem> {
        val menuItems = mutableListOf<MenuItem>()
        menuItems.add(MenuItem(Navigations.HOME.name, Icons.Filled.Home))
        menuItems.add(MenuItem(Navigations.SEARCH.name, Icons.Filled.Search))
        menuItems.add(MenuItem(Navigations.FAVORITE.name, Icons.Filled.Favorite))
        menuItems.add(MenuItem(Navigations.SETTINGS.name, Icons.Filled.Settings))
        return menuItems
    }

    val bottomMenuList = getMenuList()

    BottomNavigation {
        bottomMenuList.forEach { bottomMenu ->
            BottomNavigationItem(
                selected = bottomMenu.title == "Home",
                onClick = {
                },
                icon = {
                    Icon(
                        imageVector = bottomMenu.icon,
                        contentDescription = bottomMenu.title
                    )
                })
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MySnackHost(state: SnackbarHostState) {
    SnackbarHost(
        state,
        snackbar = { data ->
            Snackbar(
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.Black, RoundedCornerShape(8.dp)),
                action = {
                    Text(
                        text = "HIDE",
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                state.currentSnackbarData?.dismiss()
                            },
                        style = androidx.compose.ui.text.TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colors.primary,
                            fontSize = 18.sp
                        )
                    )
                }
            ) {
                Text(text = data.message)
            }
        })
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FloatingActionButtonSample(scaffoldState: ScaffoldState) {
    val scope = rememberCoroutineScope()
    FloatingActionButton(onClick = {
        scope.launch {
            when (scaffoldState.snackbarHostState.showSnackbar(
                message = "Jetpack Compose Snackbar",
                actionLabel = "Ok"
            )) {
                SnackbarResult.Dismissed ->
                    Log.d("TAB", "Dismissed")
                SnackbarResult.ActionPerformed ->
                    Log.d("TAB", "Action!")
            }
        }
    }) {
        Text("X")
    }
}


