package com.iperovv.vkcourseproject.domain.usecase

import com.iperovv.vkcourseproject.domain.AppDetailedRepository
import javax.inject.Inject

class RefreshAppDetailedUseCase @Inject constructor(
    private val repository: AppDetailedRepository,
) {
    suspend operator fun invoke(appId: String) {
        require(appId.isNotBlank())
        repository.refreshAppDetailed(appId)
    }
}
