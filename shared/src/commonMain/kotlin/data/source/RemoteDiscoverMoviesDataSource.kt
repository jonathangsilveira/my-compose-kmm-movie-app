package data.source

import data.model.DiscoverMoviesResponse
import domain.mapper.Mapper
import domain.model.MoviePosterModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter

internal class RemoteDiscoverMoviesDataSource(
    private val httpClient: HttpClient,
    private val sessionDataSource: SessionDataSource,
    private val mapper: Mapper<DiscoverMoviesResponse, List<MoviePosterModel>>
) : DiscoverMoviesDataSource {
    override suspend fun getNowPlayingMovies(
        language: String,
        page: Int
    ): List<MoviePosterModel> {
        val body = discoverMovies("now_playing", language, page)
        return mapper.map(body)
    }

    override suspend fun getPopularMovies(language: String, page: Int): List<MoviePosterModel> {
        val body = discoverMovies("popular", language, page)
        return mapper.map(body)
    }

    override suspend fun getUpcomingMovies(language: String, page: Int): List<MoviePosterModel> {
        val body = discoverMovies("upcoming", language, page)
        return mapper.map(body)
    }

    override suspend fun getTopRatedMovies(language: String, page: Int): List<MoviePosterModel> {
        val body = discoverMovies("top_rated", language, page)
        return mapper.map(body)
    }

    private suspend fun discoverMovies(
        path: String,
        language: String,
        page: Int
    ): DiscoverMoviesResponse {
        val body = httpClient
            .get(urlString = "https://api.themoviedb.org/3/movie/$path") {
                header(key = "accept", value = "application/json")
                header(
                    key = "Authorization",
                    value = sessionDataSource.getAuthorization()
                )
                parameter("language", language)
                parameter("page", page)
            }.body<DiscoverMoviesResponse>()
        return body
    }
}