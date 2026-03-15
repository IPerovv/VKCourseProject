package com.iperovv.vkcourseproject.ui.screens.applist

import com.iperovv.vkcourseproject.domain.AppListItem

sealed interface AppListScreenState {
    data object Loading : AppListScreenState

    data class Error(
        val error: String?,
    ) : AppListScreenState

    data class Success(
        val appList: List<AppListItem>,
    ) : AppListScreenState
}
