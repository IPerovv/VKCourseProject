package com.iperovv.vkcourseproject.ui.screens.applist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iperovv.vkcourseproject.ui.screens.applist.component.AppListTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppListScreen(modifier: Modifier = Modifier) {

    Scaffold(
        topBar = {
            AppListTopAppBar(
                modifier = modifier,
            )
        }
    ) { paddingValues ->
        Content(modifier = Modifier.padding(paddingValues))
    }
}

@Composable
private fun Content(modifier: Modifier = Modifier) {
    Box(
        modifier.fillMaxSize()
    )
}



