package com.iperovv.vkcourseproject.ui.screens.applist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iperovv.vkcourseproject.ui.screens.applist.component.AppListTopAppBar
import com.iperovv.vkcourseproject.ui.theme.FangHeight
import com.iperovv.vkcourseproject.ui.theme.PaddingLarge
import com.iperovv.vkcourseproject.ui.theme.VKCourseProjectTheme
import com.iperovv.vkcourseproject.domain.AppListItem as AppListItemDomainModel
import com.iperovv.vkcourseproject.ui.screens.applist.component.AppListItem as AppListItemComp
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppListScreen(
    onAppClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AppListScreenViewModel = viewModel(),
) {
    val apps by viewModel.apps

    val isSnackShown by viewModel.isSnackShown
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = modifier,
        topBar = {
            AppListTopAppBar(
                onLogoClick = {
                    if (!isSnackShown) {
                        scope.launch {
                            snackbarHostState.showSnackbar("RuStore logo clicked")
                        }
                        viewModel.onSnackShown()
                    }
                },
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ) { paddingValues ->
        Content(
            modifier =
                Modifier
                    .padding(paddingValues)
                    .offset(y = -FangHeight),
            apps = apps,
            onAppClick = onAppClick,
        )
    }
}

@Composable
private fun Content(
    onAppClick: () -> Unit,
    apps: List<AppListItemDomainModel>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(apps) { app ->
            AppListItemComp(
                app = app,
                modifier =
                    Modifier
                        .clickable(
                            onClick = { onAppClick() },
                            indication = ripple(bounded = true),
                            interactionSource = remember { MutableInteractionSource() },
                        ).padding(horizontal = PaddingLarge),
            )
        }
    }
}

@Preview(name = "AppListScreen", showBackground = true)
@Composable
private fun PreviewAppListScreen() {
    VKCourseProjectTheme {
        AppListScreen(
            onAppClick = {},
        )
    }
}
