package com.iperovv.vkcourseproject.ui.screens.applist.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.iperovv.vkcourseproject.domain.AppCategory
import com.iperovv.vkcourseproject.domain.AppListItem
import com.iperovv.vkcourseproject.ui.common.component.HorizontalDivider
import com.iperovv.vkcourseproject.ui.common.spacer.HorizontalSpacer
import com.iperovv.vkcourseproject.ui.common.spacer.VerticalSpacer
import com.iperovv.vkcourseproject.ui.common.util.getCategoryText
import com.iperovv.vkcourseproject.ui.theme.FangWidth
import com.iperovv.vkcourseproject.ui.theme.PaddingLarge
import com.iperovv.vkcourseproject.ui.theme.PaddingSmall
import com.iperovv.vkcourseproject.ui.theme.RuStoreTypography

@Composable
fun AppListItem(
    modifier: Modifier = Modifier,
    app: AppListItem,
) {
    Column(
        modifier = modifier
    ) {

        VerticalSpacer(height = FangWidth)

        Row(verticalAlignment = Alignment.CenterVertically) {

            AppIcon(iconUrl = app.iconUrl)

            HorizontalSpacer(width = PaddingLarge)

            AppTextInfo(
                name = app.name,
                slogan = app.slogan,
                category = app.category
            )
        }
        VerticalSpacer(height = (FangWidth - 1.dp))
        HorizontalDivider()
    }
}

@Composable
private fun AppIcon(
    modifier: Modifier = Modifier,
    iconUrl: String,
    size: Dp = 75.dp,
    shape: Shape = RoundedCornerShape(16.dp)
) {
    AsyncImage(
        model = iconUrl,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(size)
            .clip(shape)
    )
}

@Composable
private fun AppTextInfo(
    name: String,
    slogan: String,
    category: AppCategory,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Text(
            text = name,
            style = RuStoreTypography.bodyLarge,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
        VerticalSpacer(height = PaddingSmall)
        Text(
            text = slogan,
            style = RuStoreTypography.bodyMedium,
            fontWeight = FontWeight.Medium,
            maxLines = 1
        )
        VerticalSpacer(height = PaddingSmall)
        Text(
            text = getCategoryText(category),
            style = RuStoreTypography.bodySmall,
            fontWeight = FontWeight.ExtraLight,
            maxLines = 1
        )
    }
}
