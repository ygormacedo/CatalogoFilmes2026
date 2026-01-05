package network
import io.ktor.client.call.*
import io.ktor.client.request.*
import model.Movie
import model.MovieResponse

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