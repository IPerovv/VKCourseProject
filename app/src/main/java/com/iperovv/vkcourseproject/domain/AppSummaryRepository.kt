package com.iperovv.vkcourseproject.domain

import com.iperovv.vkcourseproject.domain.model.AppSummary

interface AppSummaryRepository {
    suspend fun getApps(): List<AppSummary>
}
