import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

import data.model.model.Movie
import data.model.repository.MovieRepository
import data.model.remote.TmdbService
import ui.components.MoviePoster

@Composable
@Preview
fun App() {
    MaterialTheme {

        val repository = remember { MovieRepository() }
        val service = remember { TmdbService() }

        var movies by remember { mutableStateOf<List<Movie>>(emptyList()) }

        LaunchedEffect(Unit) {
            movies = service.getPopularMovies()
        }

        MovieListScreen(
            movies = movies,
            repository = repository
        )
    }
}

@Composable
fun MovieListScreen(
    movies: List<Movie>,
    repository: MovieRepository
) {
    LazyColumn {
        items(movies) { movie ->

            MoviePoster(
                imageUrl = "https://image.tmdb.org/t/p/w500${movie.posterPath}",
                title = movie.title,
                modifier = Modifier.padding(12.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
