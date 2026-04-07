package com.iperovv.vkcourseproject.domain.usecase

import com.iperovv.vkcourseproject.domain.AppSummaryRepository
import com.iperovv.vkcourseproject.domain.model.AppSummary
import javax.inject.Inject

class GetListOfAppSummaryUseCase @Inject constructor(
    private val repository: AppSummaryRepository,
) {
    suspend operator fun invoke(): List<AppSummary> = repository.getApps()
}
