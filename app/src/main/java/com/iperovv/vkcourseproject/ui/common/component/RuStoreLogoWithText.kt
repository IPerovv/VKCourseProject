package com.iperovv.vkcourseproject.ui.common.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.iperovv.vkcourseproject.R
import com.iperovv.vkcourseproject.ui.common.spacer.HorizontalSpacer
import com.iperovv.vkcourseproject.ui.screens.applist.component.AppBarIcon
import com.iperovv.vkcourseproject.ui.theme.PaddingMedium
import com.iperovv.vkcourseproject.ui.theme.RuStoreBlue
import com.iperovv.vkcourseproject.ui.theme.RuStoreWhite

@Composable
fun RuStoreLogoWithText() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AppBarIcon(
            icon = painterResource(R.drawable.rustore_foreground),
            contentDescription = stringResource(R.string.rustore_logo_description),
            backgroundColor = RuStoreWhite,
            iconTint = RuStoreBlue,
            iconSize = 28.dp,
            onClick = null
        )

        HorizontalSpacer(width = PaddingMedium)

        Text(
            text = stringResource(R.string.rustore_logo_text),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = RuStoreWhite
        )
    }
}
