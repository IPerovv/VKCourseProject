package com.iperovv.vkcourseproject.ui.common.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iperovv.vkcourseproject.R
import com.iperovv.vkcourseproject.ui.common.spacer.VerticalSpacer
import com.iperovv.vkcourseproject.ui.theme.VKCourseProjectTheme

@Composable
fun ErrorPlaceholder(
    title: String,
    description: String?,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors =
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 4.dp,
            ),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_error),
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.error,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
            )

            if (description != null) {
                VerticalSpacer(8.dp)

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
                )
            }

            VerticalSpacer(24.dp)

            Button(
                onClick = { onRetry() },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(stringResource(R.string.retry))
            }
        }
    }
}

@Preview
@Composable
private fun ErrorPlaceholderPreview() {
    VKCourseProjectTheme {
        ErrorPlaceholder(
            title = "Название ошибки",
            description = "Довольно длинное описание проблемы. Проверьте, спали ли вы сегодня",
            onRetry = { },
            modifier = Modifier.size(300.dp),
        )
    }
}
