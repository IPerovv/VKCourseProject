package com.iperovv.vkcourseproject.ui.screens.applist.component

import androidx.compose.foundation.Image
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
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.iperovv.vkcourseproject.R
import com.iperovv.vkcourseproject.domain.model.AppCategory
import com.iperovv.vkcourseproject.domain.model.AppSummary
import com.iperovv.vkcourseproject.ui.common.component.AppImagePlaceholder
import com.iperovv.vkcourseproject.ui.common.component.HorizontalDivider
import com.iperovv.vkcourseproject.ui.common.spacer.HorizontalSpacer
import com.iperovv.vkcourseproject.ui.common.spacer.VerticalSpacer
import com.iperovv.vkcourseproject.ui.common.util.getCategoryText
import com.iperovv.vkcourseproject.ui.theme.FangWidth
import com.iperovv.vkcourseproject.ui.theme.PaddingLarge
import com.iperovv.vkcourseproject.ui.theme.PaddingSmall
import com.iperovv.vkcourseproject.ui.theme.RuStoreTypography
import com.iperovv.vkcourseproject.ui.theme.VKCourseProjectTheme

@Composable
fun AppListItem(
    app: AppSummary,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        VerticalSpacer(height = FangWidth)

        Row(verticalAlignment = Alignment.CenterVertically) {
            AppIcon(iconUrl = app.iconUrl)

            HorizontalSpacer(width = PaddingLarge)

            AppTextInfo(
                name = app.name,
                slogan = app.slogan,
                category = app.category,
            )
        }
        VerticalSpacer(height = (FangWidth - 1.dp))
        HorizontalDivider()
    }
}

@Composable
private fun AppIcon(
    iconUrl: String?,
    modifier: Modifier = Modifier,
    size: Dp = 75.dp,
    shape: Shape = RoundedCornerShape(16.dp),
) {
    val isPreview = LocalInspectionMode.current

    if (isPreview) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier =
                modifier
                    .size(size)
                    .clip(shape),
        )
    } else {
        SubcomposeAsyncImage(
            model = iconUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier =
                modifier
                    .size(size)
                    .clip(shape),
            error = {
                AppImagePlaceholder(
                    modifier = Modifier.size(size),
                    error = true,
                )
            },
            loading = {
                AppImagePlaceholder(
                    modifier = Modifier.size(size),
                    error = false,
                )
            },
        )
    }
}

@Composable
private fun AppTextInfo(
    name: String,
    slogan: String?,
    category: AppCategory,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        Text(
            text = name,
            style = RuStoreTypography.bodyLarge,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
        )
        VerticalSpacer(height = PaddingSmall)
        Text(
            text = slogan ?: "",
            style = RuStoreTypography.bodyMedium,
            fontWeight = FontWeight.Medium,
            maxLines = 1,
        )
        VerticalSpacer(height = PaddingSmall)
        Text(
            text = getCategoryText(category),
            style = RuStoreTypography.bodySmall,
            fontWeight = FontWeight.ExtraLight,
            maxLines = 1,
        )
    }
}

private val sampleApp =
    AppSummary(
        name = "Гильдия Героев: Экшен",
        category = AppCategory.GAME,
        iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        slogan = "Легендарный рейд героев",
    )

@Preview(name = "AppSummary Preview", showBackground = true)
@Composable
private fun PreviewAppListItem() {
    VKCourseProjectTheme {
        AppListItem(app = sampleApp)
    }
}
