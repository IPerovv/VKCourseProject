@file:Suppress("ktlint:standard:property-naming")

package com.iperovv.vkcourseproject.ui.common.preview

import com.iperovv.vkcourseproject.domain.model.AppCategory
import com.iperovv.vkcourseproject.domain.model.AppDetailed
import com.iperovv.vkcourseproject.domain.model.AppSummary

object PreviewData {
    const val id = "1231-1231-asda-213s"
    const val name = "Гильдия Героев: Экшен ММО РПГ"
    const val developer = "VK Play"
    val category = AppCategory.GAME
    const val ageRating = 12
    const val size = 223.7f
    const val iconUrl = "https://static.rustore.ru/imgproxy/..."
    val screenshotUrls =
        listOf(
            "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp",
            "https://static.rustore.ru/imgproxy/dZCvNtRKKFpzOmGlTxLszUPmwi661IhXynYZGsJQvLw/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/60ec4cbc-dcf6-4e69-aa6f-cc2da7de1af6.jpg@webp",
            "https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp",
            "https://static.rustore.ru/imgproxy/TjeurtC7BczOVJt74XhjGYuQnG1l4rx6zpDqyMb00GY/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/08318f76-7a9c-43aa-b4a7-1aa878d00861.jpg@webp",
        )
    const val descriptionShort = "Легендарный рейд"
    const val descriptionLong = "Легендарный рейд героев в Фэнтези РПГ. Станьте героем гильдии и зразите мастера подземелья!"

    val appDetailed =
        AppDetailed(
            id = id,
            name = name,
            developer = developer,
            category = category,
            ageRating = ageRating,
            size = size,
            iconUrl = iconUrl,
            screenshotUrlList = screenshotUrls,
            description = descriptionLong,
            isInWishlist = false,
        )

    val appSummary =
        AppSummary(
            id = id,
            name = name,
            description = descriptionShort,
            category = category,
            iconUrl = iconUrl,
        )
}
