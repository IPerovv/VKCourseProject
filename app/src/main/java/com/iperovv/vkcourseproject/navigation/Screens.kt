package com.iperovv.vkcourseproject.navigation

import kotlinx.serialization.Serializable

sealed class Screens {
    @Serializable
    data object AppListScreens : Screens()

    @Serializable
    data class AppDetailedScreens(
        val appId: String,
    ) : Screens()
}
