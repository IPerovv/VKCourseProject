package com.iperovv.vkcourseproject.domain

import com.iperovv.vkcourseproject.domain.model.AppDetailed
import kotlinx.coroutines.flow.Flow

interface AppDetailedRepository {
    fun observeAppDetailed(id: String): Flow<AppDetailed>

    suspend fun toggleWishlist(id: String)

    suspend fun refreshAppDetailed(appId: String)
}
