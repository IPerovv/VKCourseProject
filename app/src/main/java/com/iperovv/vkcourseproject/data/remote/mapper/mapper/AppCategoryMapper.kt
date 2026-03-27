package com.iperovv.vkcourseproject.data.remote.mapper.mapper

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

fun AppCategory.toCategoryString(): String? =
    when (this) {
        AppCategory.GAME -> "игры"
        AppCategory.PHOTO_AND_VIDEO -> "фото и видео"
        AppCategory.PRODUCTIVITY -> "производительность"
        AppCategory.FOOD_AND_DRINK -> "еда и напитки"
        AppCategory.EDUCATION -> "образование"
        AppCategory.LIFESTYLE -> "образ жизни"
        AppCategory.SHOPPING -> "шопинг"
        AppCategory.NEWS -> "новости"
        AppCategory.MUSIC -> "музыка"
        AppCategory.FINANCE -> "финансы"
        AppCategory.UTILITIES -> "утилиты"
        AppCategory.NAVIGATION -> "навигация"
        AppCategory.COMMUNICATION -> "общение"
        AppCategory.BUSINESS -> "бизнес"
        AppCategory.WEATHER -> "погода"
        AppCategory.ENTERTAINMENT -> "развлечения"
        AppCategory.BOOKS_AND_REFERENCE -> "книги и справочники"
        AppCategory.HEALTH_AND_FITNESS -> "здоровье и фитнес"
        AppCategory.APP -> null
    }
