package composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun MovieDetailScreen(
    modifier: Modifier = Modifier,
    isRated: Boolean = false,
    onNavigationClick: () -> Unit = {},
    onRateChange: (Boolean) -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
                .requiredHeight(height = 352.dp)
        ) {
            MovieDetailsHeader(
                modifier = Modifier.matchParentSize()
                    .padding(bottom = 23.dp),
                backdropPath = "tmU7GeKVybMWFButWEGl2M4GeiP.jpg",
                backdropImageDescription = "Backdrop image for movie ",
                onNavigationClick = onNavigationClick
            )
            MovieStatsBar(
                modifier = Modifier.fillMaxWidth().wrapContentHeight()
                    .padding(start = 16.dp)
                    .align(alignment = Alignment.BottomEnd),
                isRated = isRated,
                onRateChange = onRateChange
            )
        }
    }
}

@Composable
fun MovieDetailsHeader(
    modifier: Modifier = Modifier,
    backdropPath: String,
    backdropSizeQualifier: String = "w300",
    backdropImageDescription: String? = null,
    onNavigationClick: () -> Unit = {}
) {
    Box(modifier) {
        PosterImage(
            modifier = Modifier
                .matchParentSize()
                .clip(shape = RoundedCornerShape(bottomStart = 48.dp)),
            size = backdropSizeQualifier,
            path = backdropPath,
            contentDescription = backdropImageDescription
        )
        IconButton(
            onClick = { onNavigationClick() },
            modifier = Modifier.padding(top = 32.dp, start = 16.dp)
                .align(alignment = Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Navigate to previous screen",
                tint = Color.Green,
                modifier = Modifier.size(size = 24.dp)
            )
        }
    }
}

@Composable
fun MovieStatsBar(
    modifier: Modifier = Modifier,
    isRated: Boolean,
    onRateChange: (Boolean) -> Unit
) {
    Surface(
        modifier = modifier,
        elevation = 6.dp,
        shape = RoundedCornerShape(topStart = 32.dp, bottomStart = 32.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp)
                .defaultMinSize(minHeight = 56.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StatsTile(
                label = "8.2/10",
                info = "150,212",
                iconTint = Color.Yellow,
                iconImageVector = Icons.Default.Star
            )
            RateToggleButton(
                modifier = Modifier.wrapContentSize(),
                isRated = isRated,
                label = if (isRated) "Rated" else "Rate",
                onRateChange = onRateChange
            )
            StatsTile(
                label = "Metascore",
                info = "62 critic reviews"
            ) {
                Surface(
                    modifier = Modifier.size(24.dp),
                    color = Color.Green,
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(
                        text = "86",
                        modifier = Modifier.fillMaxSize(),
                        style = MaterialTheme.typography.caption,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun RateToggleButton(
    modifier: Modifier,
    isRated: Boolean,
    label: String,
    iconContentDescription: String? = null,
    onRateChange: (Boolean) -> Unit = {}
) {
    IconToggleButton(
        onCheckedChange = onRateChange,
        modifier = modifier,
        checked = isRated
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.ThumbUp,
                contentDescription = iconContentDescription,
                modifier = Modifier.size(24.dp),
                tint = if (isRated) Color.Yellow else Color.White
            )
            Text(
                text = label,
                modifier = Modifier.wrapContentSize(),
                style = MaterialTheme.typography.subtitle2
            )
        }
    }
}