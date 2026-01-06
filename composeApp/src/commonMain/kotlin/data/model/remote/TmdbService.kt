package data.model.remote

import data.model.model.Movie
import data.model.model.MovieResponse
import data.model.network.httpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class TmdbService {

    private val apiKey = "80ee98181f935f7d733322082c388435"
    // CHAVE API DE ACESSO

    suspend fun getPopularMovies(): List<Movie> {
        val response: MovieResponse = httpClient.get(
            "https://api.themoviedb.org/3/movie/popular"
        ) {
            parameter("api_key", apiKey)
            parameter("language", "pt-BR")
        }.body()

        return response.results
    }

    suspend fun searchMovies(query: String): List<Movie> {
        val response: MovieResponse = httpClient.get(
            "https://api.themoviedb.org/3/search/movie"
        ) {
            parameter("api_key", apiKey)
            parameter("query", query)
            parameter("language", "pt-BR")
        }.body()

        return response.results
    }
}