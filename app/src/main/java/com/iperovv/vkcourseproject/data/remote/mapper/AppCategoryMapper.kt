package com.iperovv.vkcourseproject.data.remote.mapper

import com.iperovv.vkcourseproject.domain.model.AppCategory

fun String?.toAppCategory(): AppCategory =
    when (this?.uppercase()) {
        "APP" -> AppCategory.APP
        "GAME" -> AppCategory.GAME
        else -> AppCategory.APP
    }
