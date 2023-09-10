package domain.repository

import domain.model.MoviePosterSectionModel

interface DiscoverMoviesRepository {
    suspend fun getMovies(): List<MoviePosterSectionModel>
}