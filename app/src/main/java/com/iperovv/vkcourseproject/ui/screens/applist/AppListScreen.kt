package com.iperovv.vkcourseproject.ui.screens.applist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iperovv.vkcourseproject.domain.AppCategory
import com.iperovv.vkcourseproject.ui.screens.applist.component.AppListTopAppBar
import com.iperovv.vkcourseproject.ui.theme.FangHeight
import com.iperovv.vkcourseproject.domain.AppListItem as AppListItemDomainModel
import com.iperovv.vkcourseproject.ui.screens.applist.component.AppListItem as AppListItemComp

@Composable
fun AppListScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            AppListTopAppBar(
                modifier = modifier,
            )
        }
    ) { paddingValues ->
        Content(
            modifier = Modifier
                .padding(paddingValues)
                .offset(y = -FangHeight),
            apps = getApps()
        )
    }
}

@Composable
private fun Content(modifier: Modifier = Modifier, apps: List<AppListItemDomainModel>) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(apps) { app ->
            AppListItemComp(app)
        }
    }
}

private fun getApps(): List<AppListItemDomainModel> = List(15) {
    AppListItemDomainModel(
        name = "Гильдия Героев: Экшен",
        category = AppCategory.GAME,
        iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
        slogan = "Легендарный рейд героев"
    )
}
