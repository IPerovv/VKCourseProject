package com.iperovv.vkcourseproject.domain.usecase

import com.iperovv.vkcourseproject.domain.AppDetailedRepository
import com.iperovv.vkcourseproject.domain.model.AppDetailed
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveAppDetailedUseCase @Inject constructor(
    private val repository: AppDetailedRepository,
) {
    operator fun invoke(appId: String): Flow<AppDetailed> = repository.observeAppDetailed(appId)
}
