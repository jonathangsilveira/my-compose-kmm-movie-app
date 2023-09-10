package domain.usecase

import domain.model.MoviePosterSectionModel
import domain.repository.DiscoverMoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class GetDiscoverMoviesUseCase(
    private val repo: DiscoverMoviesRepository,
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) {

    suspend operator fun invoke(): Result<List<MoviePosterSectionModel>> {
        return withContext(coroutineContext) {
            runCatching { repo.getMovies() }
        }
    }
}