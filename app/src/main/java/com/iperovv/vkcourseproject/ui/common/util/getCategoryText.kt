package com.iperovv.vkcourseproject.ui.common.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.iperovv.vkcourseproject.R
import com.iperovv.vkcourseproject.domain.model.AppCategory

@Composable
fun getCategoryText(category: AppCategory): String =
    when (category) {
        AppCategory.APP -> stringResource(R.string.category_app)
        AppCategory.GAME -> stringResource(R.string.category_game)
        AppCategory.PHOTO_AND_VIDEO -> stringResource(R.string.category_photo_and_video)
        AppCategory.PRODUCTIVITY -> stringResource(R.string.category_productivity)
        AppCategory.FOOD_AND_DRINK -> stringResource(R.string.category_food_and_drink)
        AppCategory.EDUCATION -> stringResource(R.string.category_education)
        AppCategory.LIFESTYLE -> stringResource(R.string.category_lifestyle)
        AppCategory.SHOPPING -> stringResource(R.string.category_shopping)
        AppCategory.NEWS -> stringResource(R.string.category_news)
        AppCategory.MUSIC -> stringResource(R.string.category_music)
        AppCategory.FINANCE -> stringResource(R.string.category_finance)
        AppCategory.UTILITIES -> stringResource(R.string.category_utilities)
        AppCategory.NAVIGATION -> stringResource(R.string.category_navigation)
        AppCategory.COMMUNICATION -> stringResource(R.string.category_communication)
        AppCategory.BUSINESS -> stringResource(R.string.category_business)
        AppCategory.WEATHER -> stringResource(R.string.category_weather)
        AppCategory.ENTERTAINMENT -> stringResource(R.string.category_entertainment)
        AppCategory.BOOKS_AND_REFERENCE -> stringResource(R.string.category_books_and_reference)
        AppCategory.HEALTH_AND_FITNESS -> stringResource(R.string.category_health_and_fitness)
    }
