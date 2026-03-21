package com.iperovv.vkcourseproject.domain.model

data class AppSummary(
    val id: String,
    val name: String,
    val description: String?,
    val category: AppCategory,
    val iconUrl: String?,
)
