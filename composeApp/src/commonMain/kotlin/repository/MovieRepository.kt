package repository

import model.MovieStatus

class MovieRepository {

    private val movieStatusMap = mutableMapOf<Int, MovieStatus>()

    fun setStatus(movieId: Int, status: MovieStatus) {
        movieStatusMap[movieId] = status
    }

    fun getStatus(movieId: Int): MovieStatus? {
        return movieStatusMap[movieId]
    }
}