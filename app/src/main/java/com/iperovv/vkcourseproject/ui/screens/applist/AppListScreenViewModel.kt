package com.iperovv.vkcourseproject.ui.screens.applist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.iperovv.vkcourseproject.domain.AppCategory
import com.iperovv.vkcourseproject.domain.AppListItem

class AppListScreenViewModel : ViewModel() {
    private val _apps = mutableStateOf<List<AppListItem>>(getApps())
    val apps: State<List<AppListItem>> = _apps

    private val _isSnackShown = mutableStateOf<Boolean>(false)
    val isSnackShown: State<Boolean> = _isSnackShown

    fun onSnackShown() {
        _isSnackShown.value = true
    }
}

private fun getApps(): List<AppListItem> =
    List(15) {
        AppListItem(
            name = "Гильдия Героев: Экшен",
            category = AppCategory.GAME,
            iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
            slogan = "Легендарный рейд героев",
        )
    }
