package com.iperovv.vkcourseproject.data.repository

import com.iperovv.vkcourseproject.data.remote.api.AppsApi
import com.iperovv.vkcourseproject.data.remote.mapper.AppDetailedMapper
import com.iperovv.vkcourseproject.di.qualifiers.IoDispatcher
import com.iperovv.vkcourseproject.domain.AppDetailedRepository
import com.iperovv.vkcourseproject.domain.model.AppDetailed
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

@Suppress("ktlint:standard:class-signature")
class AppDetailedRepositoryImpl
    @Inject
    constructor(
        private val appsApi: AppsApi,
        private val appDetailedMapper: AppDetailedMapper,
        @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    ) : AppDetailedRepository {
        override suspend fun getDetailedApp(appId: String): AppDetailed =
            withContext(ioDispatcher) {
                val appDetailedDto = appsApi.getDetailedApp(appId)
                val appDetailed = appDetailedMapper.fromDto(appDetailedDto)
                return@withContext appDetailed
            }
    }
