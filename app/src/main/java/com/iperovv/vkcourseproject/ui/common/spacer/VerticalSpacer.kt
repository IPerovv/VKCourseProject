package com.iperovv.vkcourseproject.ui.common.spacer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp


@Composable
fun VerticalSpacer(
    color: Color = Color.Transparent,
    height: Dp
) {
    Spacer(
        Modifier
            .fillMaxWidth()
            .height(height = height)
            .background(color = color)
    )
}
