package com.iperovv.vkcourseproject.ui.screens.applist.component

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import com.iperovv.vkcourseproject.ui.theme.FangHeight
import com.iperovv.vkcourseproject.ui.theme.FangWidth

class FangsShape(
    private val fangHeight: Dp = FangHeight,
    private val fangWidth: Dp = FangWidth,
    private val deepControlPoint: Pair<Float, Float> = 0.1f to 0.6f,
    private val shallowControlPoint: Pair<Float, Float> = 0.15f to 0.15f,
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        val h = with(density) { fangHeight.toPx() }
        val w = with(density) { fangWidth.toPx() }

        val baseline = size.height - h

        val path =
            Path().apply {
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
                    baseline,
                )

                lineTo(w, baseline)

                cubicTo(
                    w * shallowControlPoint.first,
                    baseline + h * shallowControlPoint.second,
                    w * deepControlPoint.first,
                    baseline + h * deepControlPoint.second,
                    0f,
                    size.height,
                )

                lineTo(0f, baseline)
                close()
            }

        return Outline.Generic(path)
    }
}
