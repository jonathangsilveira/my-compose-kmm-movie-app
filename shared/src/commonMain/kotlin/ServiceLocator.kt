import domain.repository.DiscoverMoviesRepository
import data.repository.DiscoverMoviesRepositoryImpl
import data.mapper.DiscoverMovieResponseToMoviePosterCardMapper
import data.createHttpClient
import data.createJson
import data.source.RemoteDiscoverMoviesDataSource
import data.source.SessionDataSourceImpl
import domain.usecase.GetDiscoverMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlin.coroutines.CoroutineContext

object ServiceLocator {
    private fun provideDiscoverMoviesRepository(): DiscoverMoviesRepository {
        return DiscoverMoviesRepositoryImpl(
            remoteDataSource = RemoteDiscoverMoviesDataSource(
                httpClient = createHttpClient(
                    createJson()
                ),
                sessionDataSource = SessionDataSourceImpl(),
                mapper = DiscoverMovieResponseToMoviePosterCardMapper()
            )
        )
    }

    fun provideDiscoverMoviesUseCase(
        nowPlayingRepository: DiscoverMoviesRepository = provideDiscoverMoviesRepository(),
        coroutineContext: CoroutineContext = Dispatchers.IO
    ) = GetDiscoverMoviesUseCase(nowPlayingRepository, coroutineContext)
}