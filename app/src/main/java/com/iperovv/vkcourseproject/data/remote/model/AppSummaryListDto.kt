package com.iperovv.vkcourseproject.data.remote.model

// Подумал сделать именно так потому, что обычно с апри приходит именно в таком виде
data class AppSummaryListDto(
    val items: List<AppSummaryDto> = emptyList(),
)
