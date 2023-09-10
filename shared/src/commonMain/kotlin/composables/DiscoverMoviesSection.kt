package composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.model.MoviePosterSectionModel

@Composable
fun DiscoverMovieSection(
    modifier: Modifier,
    model: MoviePosterSectionModel,
    onItemClick: () -> Unit = {}
) {
    Section(
        modifier = modifier,
        header = {
            Header(
                modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(),
                title = model.title
            )
            Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))
        },
        content = {
            LazyRow(
                contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
            ) {
                items(
                    items = model.items,
                    key = { item -> item.id },
                    itemContent = {
                        MoviePosterCard(
                            model = it,
                            onClick = onItemClick
                        )
                    }
                )
            }
        }
    )
}