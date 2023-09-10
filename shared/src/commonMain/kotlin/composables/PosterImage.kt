package composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun PosterImage(
    modifier: Modifier = Modifier,
    path: String,
    contentDescription: String? = null,
    size: String,
    onClick: () -> Unit = {}
) {
    KamelImage(
        resource = asyncPainterResource(data = buildUrl(size, path)),
        contentScale = ContentScale.FillBounds,
        modifier = modifier.clickable { onClick() },
        contentDescription = contentDescription,
        onLoading = {
            CircularProgressIndicator(
                modifier = modifier.size(56.dp).wrapContentSize().align(Alignment.Center)
            )
        },
        onFailure = {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = Icons.Filled.Warning,
                    modifier = Modifier.size(72.dp)
                        .wrapContentSize()
                        .align(Alignment.Center),
                    contentDescription = null
                )
            }
        }
    )
}