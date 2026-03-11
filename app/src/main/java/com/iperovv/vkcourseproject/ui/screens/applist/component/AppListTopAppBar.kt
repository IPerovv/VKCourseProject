package com.iperovv.vkcourseproject.ui.screens.applist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.iperovv.vkcourseproject.R
import com.iperovv.vkcourseproject.ui.theme.RuStoreBlue
import com.iperovv.vkcourseproject.ui.theme.RuStoreCustomBlue
import com.iperovv.vkcourseproject.ui.theme.RuStoreWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppListTopAppBar(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(
                color = RuStoreBlue,
                shape = FangsShape()
            )
    ) {
        TopAppBarRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp).padding(top = 16.dp),
        )
    }
}

@Composable
private fun TopAppBarRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color = RuStoreWhite),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.rustore_foreground),
                    contentDescription = stringResource(R.string.rustore_logo_description),
                    modifier = Modifier.size(28.dp),
                    tint = RuStoreBlue
                )
            }
            Spacer(Modifier.width(8.dp))
            Text(
                text = "RuStore",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = RuStoreWhite
            )
        }
        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color = RuStoreCustomBlue)
                .clickable(
                    onClick = { /* TODO() */ },
                    indication = ripple(bounded = true),
                    interactionSource = remember { MutableInteractionSource() }
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.outline_view_cozy_24),
                contentDescription = stringResource(R.string.change_to_grid_button_description),
                modifier = Modifier.size(24.dp),
                tint = RuStoreWhite
            )
        }
    }
}