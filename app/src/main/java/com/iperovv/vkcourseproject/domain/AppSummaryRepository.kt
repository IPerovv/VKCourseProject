package com.iperovv.vkcourseproject.domain

import com.iperovv.vkcourseproject.domain.model.AppSummary

interface AppSummaryRepository {
    fun getApps(): List<AppSummary>
}
