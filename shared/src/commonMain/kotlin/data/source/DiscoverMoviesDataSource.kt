package data.source

import domain.model.MoviePosterModel

interface DiscoverMoviesDataSource {
    suspend fun getNowPlayingMovies(
        language: String,
        page: Int = 1
    ) : List<MoviePosterModel>

    suspend fun getPopularMovies(
        language: String,
        page: Int = 1
    ) : List<MoviePosterModel>

    suspend fun getUpcomingMovies(
        language: String,
        page: Int = 1
    ) : List<MoviePosterModel>

    suspend fun getTopRatedMovies(
        language: String,
        page: Int = 1
    ) : List<MoviePosterModel>
}