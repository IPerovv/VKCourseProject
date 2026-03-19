package com.iperovv.vkcourseproject.data

import com.iperovv.vkcourseproject.data.remote.AppsApi
import com.iperovv.vkcourseproject.data.remote.mapper.AppSummaryMapper
import com.iperovv.vkcourseproject.domain.AppSummaryRepository
import com.iperovv.vkcourseproject.domain.model.AppSummary

class AppSummaryRepositoryImpl : AppSummaryRepository {
    // В следующем дз будет инжектиться
    val api = AppsApi()
    val mapper = AppSummaryMapper()

    override fun getApps(): List<AppSummary> {
        val appSummaryListDto = api.getAppList()
        val apps = appSummaryListDto.items.map { mapper.fromDto(it) }
        return apps
    }
}
