package com.iperovv.vkcourseproject.ui.common.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.iperovv.vkcourseproject.R
import com.iperovv.vkcourseproject.domain.AppCategory

@Composable
fun getCategoryText(category: AppCategory): String =
    when (category) {
        AppCategory.APP -> stringResource(R.string.category_app)
        AppCategory.GAME -> stringResource(R.string.category_game)
    }
