package com.iperovv.vkcourseproject.data

import com.iperovv.vkcourseproject.data.remote.AppsApi
import com.iperovv.vkcourseproject.data.remote.mapper.AppDetailedMapper
import com.iperovv.vkcourseproject.domain.AppDetailedRepository
import com.iperovv.vkcourseproject.domain.model.AppDetailed

class AppDetailedRepositoryImpl : AppDetailedRepository {
    // В следующем дз будет инжектиться
    val api = AppsApi()
    val mapper = AppDetailedMapper()

    override fun getDetailedApp(): AppDetailed {
        val appDetailedDto = api.getDetailedApp()
        val appDetailed = mapper.fromDto(appDetailedDto)
        return appDetailed
    }
}
