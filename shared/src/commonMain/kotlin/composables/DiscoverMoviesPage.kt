package composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.model.MoviePosterSectionModel

@Composable
fun DiscoverMoviesPage(
    modifier: Modifier = Modifier,
    sections: List<MoviePosterSectionModel>
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(all = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(
            items = sections,
            key = { index, _ -> index },
            itemContent = { _, moviePoster ->
                DiscoverMovieSection(
                    modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                    model = moviePoster
                )
            }
        )
    }
}