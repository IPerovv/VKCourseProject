package com.iperovv.vkcourseproject.ui.screens.appdetails

import androidx.compose.runtime.Immutable
import com.iperovv.vkcourseproject.domain.DetailedApp

@Immutable
sealed interface AppDetailsScreenState {
    data object Loading : AppDetailsScreenState

    data class Error(
        val error: String?,
    ) : AppDetailsScreenState

    data class Success(
        val detailedApp: DetailedApp,
    ) : AppDetailsScreenState
}
