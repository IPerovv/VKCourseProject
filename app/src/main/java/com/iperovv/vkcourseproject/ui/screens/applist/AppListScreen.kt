package com.iperovv.vkcourseproject.ui.screens.applist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.iperovv.vkcourseproject.domain.AppCategory
import com.iperovv.vkcourseproject.ui.screens.applist.component.AppListTopAppBar
import com.iperovv.vkcourseproject.ui.theme.FangHeight
import com.iperovv.vkcourseproject.ui.theme.PaddingLarge
import com.iperovv.vkcourseproject.ui.theme.VKCourseProjectTheme
import com.iperovv.vkcourseproject.domain.AppListItem as AppListItemDomainModel
import com.iperovv.vkcourseproject.ui.screens.applist.component.AppListItem as AppListItemComp

@Composable
fun AppListScreen(
    onAppClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            AppListTopAppBar()
        },
    ) { paddingValues ->
        Content(
            modifier =
                Modifier
                    .padding(paddingValues)
                    .offset(y = -FangHeight),
            apps = getApps(),
            onAppClick = onAppClick,
        )
    }
}

@Composable
private fun Content(
    onAppClick: () -> Unit,
    apps: List<AppListItemDomainModel>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(apps) { app ->
            AppListItemComp(
                app = app,
                modifier =
                    Modifier
                        .clickable(
                            onClick = { onAppClick() },
                            indication = ripple(bounded = true),
                            interactionSource = remember { MutableInteractionSource() },
                        ).padding(horizontal = PaddingLarge),
            )
        }
    }
}

private fun getApps(): List<AppListItemDomainModel> =
    List(15) {
        AppListItemDomainModel(
            name = "Гильдия Героев: Экшен",
            category = AppCategory.GAME,
            iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
            slogan = "Легендарный рейд героев",
        )
    }

@Preview(name = "AppListScreen", showBackground = true)
@Composable
private fun PreviewAppListScreen() {
    VKCourseProjectTheme {
        AppListScreen(onAppClick = {})
    }
}
