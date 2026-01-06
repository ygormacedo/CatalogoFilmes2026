package ui.components.screen.login.details

import data.model.model.Movie
import data.model.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MovieDetailsViewModel(
    private val repository: MovieRepository = MovieRepository()
) {

    private val _movie = MutableStateFlow<Movie?>(null)
    val movie: StateFlow<Movie?> = _movie

    suspend fun loadMovie(movieId: Int) {
        _movie.value = repository.getMovieDetails(movieId)
    }
}