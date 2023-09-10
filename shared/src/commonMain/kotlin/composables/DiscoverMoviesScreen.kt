package composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import presentation.DiscoverMoviesViewState

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NowPlayingMoviesScreen(
    viewState: DiscoverMoviesViewState,
    modifier: Modifier = Modifier,
    onPull: () -> Unit = {}
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = viewState.isLoading,
        onRefresh = onPull
    )
    Box(
        modifier = modifier.background(
            color = MaterialTheme.colors.background
        ).pullRefresh(pullRefreshState),
    ) {
        if (viewState.errorMessage.isNullOrEmpty()) {
            DiscoverMoviesPage(
                modifier = Modifier.fillMaxSize(),
                sections = viewState.sections
            )
        } else {
            ErrorMessage(
                message = viewState.errorMessage,
                modifier = Modifier.wrapContentSize()
                    .align(Alignment.Center),
                onRetry = onPull
            )
        }
        PullRefreshIndicator(
            refreshing = viewState.isLoading,
            state = pullRefreshState,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}
