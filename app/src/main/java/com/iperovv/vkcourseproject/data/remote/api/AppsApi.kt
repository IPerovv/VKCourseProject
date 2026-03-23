package com.iperovv.vkcourseproject.data.remote.api

import com.iperovv.vkcourseproject.data.remote.model.AppDetailedDto
import com.iperovv.vkcourseproject.data.remote.model.AppSummaryDto
import retrofit2.http.GET
import retrofit2.http.Path

interface AppsApi {
    @GET("catalog")
    suspend fun getAppList(): List<AppSummaryDto>

    @GET("catalog/{id}")
    suspend fun getDetailedApp(
        @Path("id") id: String,
    ): AppDetailedDto
}
