package com.iperovv.vkcourseproject.ui.screens.appdetailed

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iperovv.vkcourseproject.R
import com.iperovv.vkcourseproject.domain.model.AppDetailed
import com.iperovv.vkcourseproject.ui.common.component.ErrorPlaceholder
import com.iperovv.vkcourseproject.ui.screens.appdetailed.component.AppDescription
import com.iperovv.vkcourseproject.ui.screens.appdetailed.component.AppDetailedHeader
import com.iperovv.vkcourseproject.ui.screens.appdetailed.component.Developer
import com.iperovv.vkcourseproject.ui.screens.appdetailed.component.InstallButton
import com.iperovv.vkcourseproject.ui.screens.appdetailed.component.ScreenshotsList
import com.iperovv.vkcourseproject.ui.screens.appdetailed.component.Toolbar
import com.iperovv.vkcourseproject.ui.theme.VKCourseProjectTheme

@Composable
fun AppDetailedScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AppDetailedScreenViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    when (val currentState = state) {
        is AppDetailedScreenState.Error ->

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

        is AppDetailedScreenState.Loading -> {
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

        is AppDetailedScreenState.Success ->
            AppDetailedContent(
                onNavigateBack = onNavigateBack,
                modifier = modifier,
                app = currentState.appDetailed,
            )
    }
}

@Composable
private fun AppDetailedContent(
    onNavigateBack: () -> Unit,
    app: AppDetailed,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val underDevelopmentText = stringResource(R.string.under_developement)

    var descriptionCollapsed by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier =
            modifier
                .statusBarsPadding(),
    ) {
        Toolbar(
            onBackClick = {
                onNavigateBack()
            },
            onShareClick = {
                Toast.makeText(context, underDevelopmentText, Toast.LENGTH_SHORT).show()
            },
        )
        Spacer(Modifier.height(8.dp))
        AppDetailedHeader(
            app = app,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(16.dp))
        InstallButton(
            onClick = {
                Toast.makeText(context, underDevelopmentText, Toast.LENGTH_SHORT).show()
            },
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(12.dp))
        ScreenshotsList(
            screenshotUrlList = app.screenshotUrlList,
            contentPadding = PaddingValues(horizontal = 16.dp),
        )
        Spacer(Modifier.height(12.dp))
        AppDescription(
            description = app.description,
            collapsed = descriptionCollapsed,
            onReadMoreClick = {
                descriptionCollapsed = true
            },
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(12.dp))
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.outlineVariant,
        )
        Spacer(Modifier.height(12.dp))
        Developer(
            name = app.developer,
            onClick = {
                Toast.makeText(context, underDevelopmentText, Toast.LENGTH_SHORT).show()
            },
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
        )
    }
}

@Preview
@Composable
private fun Preview() {
    VKCourseProjectTheme {
        AppDetailedScreen(
            onNavigateBack = { },
            modifier = Modifier.fillMaxSize(),
        )
    }
}
