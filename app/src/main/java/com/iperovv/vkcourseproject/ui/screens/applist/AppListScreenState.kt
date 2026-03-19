package com.iperovv.vkcourseproject.ui.screens.applist

import androidx.compose.runtime.Immutable
import com.iperovv.vkcourseproject.domain.model.AppSummary

@Immutable
sealed interface AppListScreenState {
    data object Loading : AppListScreenState

    data class Error(
        val error: String?,
    ) : AppListScreenState

    data class Success(
        val appList: List<AppSummary>,
    ) : AppListScreenState
}
