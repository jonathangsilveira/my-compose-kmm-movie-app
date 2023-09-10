package data.mapper

import data.model.DiscoverMoviesResponse
import domain.mapper.Mapper
import domain.model.MoviePosterModel

internal class DiscoverMovieResponseToMoviePosterCardMapper :
    Mapper<DiscoverMoviesResponse, List<MoviePosterModel>> {
    override fun map(source: DiscoverMoviesResponse): List<MoviePosterModel> {
        return source.results.map {
            MoviePosterModel(
                id = it.id,
                posterPath = it.posterPath,
                title = it.title
            )
        }
    }
}