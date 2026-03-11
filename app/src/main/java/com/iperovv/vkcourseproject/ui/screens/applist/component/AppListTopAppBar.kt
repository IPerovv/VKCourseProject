package com.iperovv.vkcourseproject.ui.screens.applist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.iperovv.vkcourseproject.R
import com.iperovv.vkcourseproject.ui.common.component.RuStoreLogoWithText
import com.iperovv.vkcourseproject.ui.theme.PaddingLarge
import com.iperovv.vkcourseproject.ui.theme.RuStoreBlue
import com.iperovv.vkcourseproject.ui.theme.RuStoreCustomBlue

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
        TopAppBarContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = PaddingLarge),
        )
    }
}

@Composable
private fun TopAppBarContent(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = PaddingLarge),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        RuStoreLogoWithText()

        AppBarIcon(
            icon = painterResource(R.drawable.outline_view_cozy_24),
            contentDescription = stringResource(R.string.change_to_grid_button_description),
            backgroundColor = RuStoreCustomBlue,
            onClick = { /* TODO */ }
        )
    }
}


