package com.iperovv.vkcourseproject.ui.screens.applist.component

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

class FangsShape(
    private val clawHeight: Dp = 15.dp,
    private val clawWidth: Dp = 15.dp,
    private val deepControlPoint: Pair<Float, Float> = 0.1f to 0.6f,
    private val shallowControlPoint: Pair<Float, Float> = 0.15f to 0.15f,
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val h = with(density) { clawHeight.toPx() }
        val w = with(density) { clawWidth.toPx() }

        val baseline = size.height - h

        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(size.width, 0f)
            lineTo(size.width, baseline)
            lineTo(size.width, size.height)

            cubicTo(
                size.width - w * deepControlPoint.first,
                baseline + h * deepControlPoint.second,
                size.width - w * shallowControlPoint.first,
                baseline + h * shallowControlPoint.second,
                size.width - w,
                baseline
            )

            lineTo(w, baseline)

            cubicTo(
                w * shallowControlPoint.first,
                baseline + h * shallowControlPoint.second,
                w * deepControlPoint.first,
                baseline + h * deepControlPoint.second,
                0f,
                size.height
            )

            lineTo(0f, baseline)
            close()
        }

        return Outline.Generic(path)
    }
}