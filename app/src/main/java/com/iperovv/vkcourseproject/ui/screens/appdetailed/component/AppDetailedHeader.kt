package com.iperovv.vkcourseproject.ui.screens.appdetailed.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.iperovv.vkcourseproject.R
import com.iperovv.vkcourseproject.domain.model.AppDetailed
import com.iperovv.vkcourseproject.ui.common.preview.PreviewData
import com.iperovv.vkcourseproject.ui.common.util.getCategoryText
import com.iperovv.vkcourseproject.ui.theme.VKCourseProjectTheme
import kotlin.math.roundToInt

@Composable
fun AppDetailedHeader(
    app: AppDetailed,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = app.iconUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier =
                Modifier
                    .size(128.dp)
                    .clip(RoundedCornerShape(16.dp)),
        )
        Spacer(Modifier.width(16.dp))
        Column {
            Text(
                text = getCategoryText(app.category),
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 12.sp,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = app.name,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = app.developer,
                fontSize = 12.sp,
            )
            Spacer(Modifier.height(4.dp))
            Row {
                Column(Modifier.width(IntrinsicSize.Max)) {
                    Text(
                        text = "${app.ageRating}+",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(text = stringResource(R.string.app_detailed_age))
                }
                Spacer(Modifier.width(12.dp))
                Column {
                    Text(text = "${app.size.roundToInt()} MB")
                    Spacer(Modifier.height(4.dp))
                    Text(text = stringResource(R.string.app_detailed_size))
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    val app = PreviewData.appDetailed
    VKCourseProjectTheme {
        AppDetailedHeader(app = app, modifier = Modifier.fillMaxWidth())
    }
}
