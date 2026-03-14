package com.iperovv.vkcourseproject.navigation

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object AppListScreen : Screen()

    @Serializable
    data object AppDetailsScreen : Screen()
}