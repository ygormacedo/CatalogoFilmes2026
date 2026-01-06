package data.model.repository

import data.model.model.Movie
import data.model.remote.TmdbService

class MovieRepository(
    private val service: TmdbService = TmdbService()
) {

    suspend fun getMovieDetails(movieId: Int): Movie {
        return service.getMovieDetails(movieId)
    }
}