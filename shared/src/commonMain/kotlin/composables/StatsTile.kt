package composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun StatsTile(
    label: String,
    modifier: Modifier = Modifier,
    info: String? = null,
    iconImageVector: ImageVector? = null,
    iconTint: Color = MaterialTheme.colors.onSurface,
    iconContent: (@Composable () -> Unit)? = null
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (iconImageVector != null) {
            Icon(
                imageVector = iconImageVector,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = iconTint
            )
        } else {
            iconContent?.invoke()
        }
        Text(
            text = label,
            modifier = Modifier.wrapContentSize(),
            style = MaterialTheme.typography.subtitle2
        )
        info?.let {
            Text(
                text = it,
                modifier = Modifier.wrapContentSize(),
                style = MaterialTheme.typography.subtitle2
            )
        }
    }
}