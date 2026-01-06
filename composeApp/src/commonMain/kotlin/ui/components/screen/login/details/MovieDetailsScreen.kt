package ui.components.screen.login.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import ui.components.screen.login.details.MovieDetailsViewModel

@Composable
fun MovieDetailsScreen(
    movieId: Int,
    viewModel: MovieDetailsViewModel
){
    LaunchedEffect(movieId){
        viewModel.loadMovie(movieId)
    }

    viewModel.movie.value?.let { movie ->
        Text(movie.title)
    }
}