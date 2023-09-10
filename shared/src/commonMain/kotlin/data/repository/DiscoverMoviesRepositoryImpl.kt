package data.repository

import data.source.RemoteDiscoverMoviesDataSource
import domain.model.MoviePosterSectionModel
import domain.repository.DiscoverMoviesRepository

private const val DEFAULT_LANGUAGE = "pt-BR"
internal class DiscoverMoviesRepositoryImpl(
    private val remoteDataSource: RemoteDiscoverMoviesDataSource
) : DiscoverMoviesRepository {
    override suspend fun getMovies(): List<MoviePosterSectionModel> {
        val nowPlayingMovies = remoteDataSource.getNowPlayingMovies(language = DEFAULT_LANGUAGE)
        val nowPlayingSection = MoviePosterSectionModel(
            title = "Now Playing",
            items = nowPlayingMovies
        )
        val popularMovies = remoteDataSource.getPopularMovies(language = DEFAULT_LANGUAGE)
        val popularsSection = MoviePosterSectionModel(
            title = "Popular",
            items = popularMovies
        )
        val upcomingMovies = remoteDataSource.getUpcomingMovies(language = DEFAULT_LANGUAGE)
        val upcomingSection = MoviePosterSectionModel(
            title = "Upcoming",
            items = upcomingMovies
        )
        val topRatedMovies = remoteDataSource.getUpcomingMovies(language = DEFAULT_LANGUAGE)
        val topRatedSection= MoviePosterSectionModel(
            title = "Top Rated",
            items = topRatedMovies
        )
        return listOf(nowPlayingSection, popularsSection, topRatedSection, upcomingSection)
    }
}