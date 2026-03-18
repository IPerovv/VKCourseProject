package com.iperovv.vkcourseproject.ui.screens.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iperovv.vkcourseproject.domain.AppCategory
import com.iperovv.vkcourseproject.domain.AppListItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppListScreenViewModel : ViewModel() {
    private val _state = MutableStateFlow<AppListScreenState>(AppListScreenState.Loading)
    val state: StateFlow<AppListScreenState> = _state.asStateFlow()

    private val _isSnackShown = MutableStateFlow<Boolean>(false)
    val isSnackShown: StateFlow<Boolean> = _isSnackShown

    init {
        loadApps()
    }

    fun onSnackShown() {
        _isSnackShown.value = true
    }

    fun loadApps() {
        viewModelScope.launch {
            _state.value = AppListScreenState.Loading
            runCatching {
                delay(2000L)
                val apps = getApps()
                _state.value = AppListScreenState.Success(apps)
            }.onFailure {
                // TODO Знаю, что это нечеловекочитаемо, но пусть временно будет так
                _state.value = AppListScreenState.Error(it.message)
            }
        }
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
