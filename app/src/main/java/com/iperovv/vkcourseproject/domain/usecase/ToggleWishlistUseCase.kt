package com.iperovv.vkcourseproject.domain.usecase

import com.iperovv.vkcourseproject.domain.AppDetailedRepository
import javax.inject.Inject

class ToggleWishlistUseCase @Inject constructor(
    private val repository: AppDetailedRepository,
) {
    suspend operator fun invoke(appId: String) {
        require(appId.isNotBlank())
        repository.toggleWishlist(appId)
    }
}
