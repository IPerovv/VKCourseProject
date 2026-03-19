package com.iperovv.vkcourseproject.data

import com.iperovv.vkcourseproject.data.remote.AppsApi
import com.iperovv.vkcourseproject.data.remote.mapper.AppDetailedMapper
import com.iperovv.vkcourseproject.domain.AppDetailedRepository
import com.iperovv.vkcourseproject.domain.model.AppDetailed
import javax.inject.Inject

class AppDetailedRepositoryImpl
    @Inject
    constructor(
        private val appsApi: AppsApi,
        private val appDetailedMapper: AppDetailedMapper,
    ) : AppDetailedRepository {
        override fun getDetailedApp(): AppDetailed {
            val appDetailedDto = appsApi.getDetailedApp()
            val appDetailed = appDetailedMapper.fromDto(appDetailedDto)
            return appDetailed
        }
    }
