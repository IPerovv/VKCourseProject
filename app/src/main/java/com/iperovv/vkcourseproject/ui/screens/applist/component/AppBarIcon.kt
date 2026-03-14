package com.iperovv.vkcourseproject.ui.screens.applist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.iperovv.vkcourseproject.ui.theme.RuStoreCustomBlue

@Composable
fun AppBarIcon(
    modifier: Modifier = Modifier,
    icon: Painter,
    contentDescription: String,
    backgroundColor: Color,
    iconTint: Color = MaterialTheme.colorScheme.surface, // TODO будет зависеть от темы
    iconSize: Dp = 24.dp,
    onClick: (() -> Unit)? = null,
) {
    val boxModifier = modifier
        .size(30.dp)
        .clip(RoundedCornerShape(8.dp))
        .background(color = backgroundColor)

    val finalModifier = if (onClick != null) {
        boxModifier.clickable(
            onClick = onClick,
            indication = ripple(bounded = true),
            interactionSource = remember { MutableInteractionSource() }
        )
    } else {
        boxModifier
    }

    Box(
        modifier = finalModifier,
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = icon,
            contentDescription = contentDescription,
            modifier = Modifier.size(iconSize),
            tint = iconTint
        )
    }
}

@Composable
@Preview
fun PreviewAppBarIcon() {
    AppBarIcon(
        icon = painterResource(android.R.drawable.ic_menu_edit),
        contentDescription = "Preview icon",
        backgroundColor = RuStoreCustomBlue,
        onClick = { }
    )
}
