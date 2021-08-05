package com.velmurugan.jetpackcomposeexample.ui

import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.velmurugan.jetpackcomposeexample.MainViewModel
import com.velmurugan.jetpackcomposeexample.Movie
import com.velmurugan.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme
import com.velmurugan.jetpackcomposeexample.ui.theme.Typography

@ExperimentalAnimationApi
@Composable
fun MovieList() {
    val mainViewModel = viewModel(MainViewModel::class.java)
    val movieList by mainViewModel.movieResponse.observeAsState()
    val selectedPosition = remember {
        mutableStateOf(-1)
    }


    if(movieList?.isNotEmpty() == true) {
        LazyColumn(
            Modifier
                .padding(8.dp, 8.dp)
        ) {
            itemsIndexed(items = movieList!!) { index, item ->
                MovieCard(item = item, index, selectedPosition.value) { position ->
                    selectedPosition.value = position
                }
            }
        }
    }

    mainViewModel.getMovieDetails()


}

@ExperimentalAnimationApi
@Composable
fun MovieCard(item: Movie, position: Int, selectedPosition: Int, clickListener: (Int) -> Unit) {
    val mContext = LocalContext.current

    val selectedBackground =
        if (selectedPosition == position) MaterialTheme.colors.primary else Color.Transparent

    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .clickable { clickListener(position) }
    ) {


        Column(
            Modifier
                .background(selectedBackground)
                .padding(8.dp)
        ) {


            Row {
                val painter = rememberImagePainter(data = item.imageUrl, builder = {
                    crossfade(true)
                    scale(Scale.FILL)
                })
                Image(
                    painter = painter, contentDescription = "image", modifier = Modifier
                        .width(100.dp)
                        .height(100.dp), contentScale = ContentScale.Crop
                )

                Column {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .padding(4.dp, 0.dp)
                    )

                    Text(
                        text = item.category,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier
                            .padding(4.dp, 4.dp)
                    )
                }
            }

            AnimatedVisibility(visible = selectedPosition == position) {
                Text(
                    text = item.desc,
                    style = Typography.body1,
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3,
                    modifier = Modifier
                        .padding(4.dp, 4.dp)
                )
            }

        }

    }
}


@ExperimentalAnimationApi
@Preview
@Composable
fun MovieListPreview() {
    JetpackComposeExampleTheme {
        MovieList()
    }
}

@ExperimentalAnimationApi
@Preview(name = "Selected", showBackground = true)
@Composable
fun MovieCardSelectedPreview() {
    JetpackComposeExampleTheme {
        MovieCard(
            item = Movie(
                "Velmurugan",
                "Latest",
                "https://howtodoandroid.com/images/coco.jpg",
                "Similar to Cameron's Titanic 3D, Lightstorm Entertainment oversaw the work on the 3D version of Terminator 2, which took nearly a year to finish."
            ), position = 0, selectedPosition = 0, clickListener = {})
    }
}

@ExperimentalAnimationApi
@Preview(name = "Unselected", showBackground = true)
@Composable
fun MovieCardUnSelectedPreview() {
    JetpackComposeExampleTheme {
        MovieCard(
            item = Movie(
                "Velmurugan",
                "Latest",
                "https://howtodoandroid.com/images/coco.jpg",
                "Similar to Cameron's Titanic 3D, Lightstorm Entertainment oversaw the work on the 3D version of Terminator 2, which took nearly a year to finish."
            ), position = 0, selectedPosition = -1, clickListener = {})
    }
}