package com.iperovv.vkcourseproject.ui.screens.appdetailed

import androidx.compose.runtime.Immutable
import com.iperovv.vkcourseproject.domain.model.AppDetailed

@Immutable
sealed interface AppDetailedScreenState {
    data object Loading : AppDetailedScreenState

    data class Error(
        val error: String?,
    ) : AppDetailedScreenState

    data class Success(
        val appDetailed: AppDetailed,
    ) : AppDetailedScreenState
}
