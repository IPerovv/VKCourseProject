package com.iperovv.vkcourseproject.ui.common.spacer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun HorizontalSpacer(
    width: Dp,
    color: Color = Color.Transparent,
) {
    Spacer(
        Modifier
            .fillMaxHeight()
            .width(width = width)
            .background(color = color),
    )
}
