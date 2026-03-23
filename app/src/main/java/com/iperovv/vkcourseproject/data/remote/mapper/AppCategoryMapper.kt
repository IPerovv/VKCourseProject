package com.iperovv.vkcourseproject.data.remote.mapper

import com.iperovv.vkcourseproject.domain.model.AppCategory

fun String?.toAppCategory(): AppCategory =
    when (this?.trim()?.lowercase()) {
        "игры" -> AppCategory.GAME
        "фото и видео" -> AppCategory.PHOTO_AND_VIDEO
        "производительность" -> AppCategory.PRODUCTIVITY
        "еда и напитки" -> AppCategory.FOOD_AND_DRINK
        "образование" -> AppCategory.EDUCATION
        "образ жизни" -> AppCategory.LIFESTYLE
        "шопинг" -> AppCategory.SHOPPING
        "новости" -> AppCategory.NEWS
        "музыка" -> AppCategory.MUSIC
        "финансы" -> AppCategory.FINANCE
        "утилиты" -> AppCategory.UTILITIES
        "навигация" -> AppCategory.NAVIGATION
        "общение" -> AppCategory.COMMUNICATION
        "бизнес" -> AppCategory.BUSINESS
        "погода" -> AppCategory.WEATHER
        "развлечения" -> AppCategory.ENTERTAINMENT
        "книги и справочники" -> AppCategory.BOOKS_AND_REFERENCE
        "здоровье и фитнес" -> AppCategory.HEALTH_AND_FITNESS
        else -> AppCategory.APP
    }
