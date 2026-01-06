package ui.components.screen.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import ui.components.MoviePoster
import ui.components.viewmodel.HomeViewModel


@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onMovieClick: (Int) -> Unit,
) {
    val movies by viewModel.movies.collectAsState()

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(movies) { movie ->
            MoviePoster(
                imageUrl = "https://image.tmdb.org/t/p/w500${movie.posterPath}",
                title = movie.title,
                modifier = Modifier.clickable {
                    onMovieClick(movie.id)
                }
            )
        }
    }
}