import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import composables.MovieDetailScreen

@Composable
fun MyMoviesApp() {
    MyMoviesAppTheme {
        /*val viewModel = getViewModel(
            Unit,
            viewModelFactory {
                DiscoverMoviesViewModel(getMovies = provideDiscoverMoviesUseCase())
            }
        )
        val viewState: DiscoverMoviesViewState by viewModel.viewState.collectAsState()
        NowPlayingMoviesScreen(
            viewState = viewState,
            modifier = Modifier.fillMaxSize(),
            onPull = viewModel::refreshMovies,
            onMovieClick = {

            }
        )*/
        var isMovieRated: Boolean by remember { mutableStateOf(false) }
        MovieDetailScreen(
            modifier = Modifier.fillMaxSize(),
            isRated = isMovieRated,
            onRateChange = { isRated -> isMovieRated = isRated }
        )
    }
}

@Composable
fun MyMoviesAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = if (isSystemInDarkTheme())
            darkColors(
                surface = Color.DarkGray,
                onSurface = Color.White
            )
        else
            lightColors(),
        content = content
    )
}