package com.iperovv.vkcourseproject.ui.screens.applist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.iperovv.vkcourseproject.R
import com.iperovv.vkcourseproject.domain.model.AppSummary
import com.iperovv.vkcourseproject.ui.common.component.ErrorPlaceholder
import com.iperovv.vkcourseproject.ui.screens.applist.component.AppListItem
import kotlinx.coroutines.launch

@Composable
fun AppListScreen(
    onAppClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AppListScreenViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    val isSnackShown by viewModel.isSnackShown.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val context = LocalContext.current

    Scaffold(
        modifier = modifier,
        topBar = {
            AppListTopAppBar(
                onLogoClick = {
                    if (!isSnackShown) {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                context.getString(R.string.rustore_logo_clicked),
                            )
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
        when (val currentState = state) {
            is AppListScreenState.Error -> {
                Box(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colorScheme.background),
                    contentAlignment = Alignment.Center,
                ) {
                    ErrorPlaceholder(
                        modifier = Modifier.padding(16.dp),
                        title = currentState.error ?: stringResource(R.string.an_error_occured),
                        onRetry = { },
                        description = null,
                    )
                }
            }

            is AppListScreenState.Loading -> {
                Box(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .background(color = MaterialTheme.colorScheme.background),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator()
                }
            }

            is AppListScreenState.Success ->
                Content(
                    modifier =
                        Modifier
                            .padding(paddingValues)
                            .offset(y = -FangHeight),
                    apps = currentState.appList,
                    onAppClick = onAppClick,
                )
        }
    }
}

@Composable
private fun Content(
    onAppClick: () -> Unit,
    apps: List<AppSummary>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(apps) { app ->
            AppListItem(
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
