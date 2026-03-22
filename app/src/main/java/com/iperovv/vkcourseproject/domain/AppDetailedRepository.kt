package com.iperovv.vkcourseproject.domain

import com.iperovv.vkcourseproject.domain.model.AppDetailed

interface AppDetailedRepository {
    fun getDetailedApp(): AppDetailed
}
