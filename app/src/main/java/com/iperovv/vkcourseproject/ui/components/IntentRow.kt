package com.iperovv.vkcourseproject.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.iperovv.vkcourseproject.IntentType

@Composable
fun IntentRow(
    modifier: Modifier,
    type: IntentType,
    text: String,
    onTextChange: (String) -> Unit,
    onButtonClick: (String) -> Unit
) {
    Row(modifier = modifier) {
        TextField(
            value = text,
            onValueChange = onTextChange,
            maxLines = 1,
            modifier = Modifier.weight(0.5f)
        )

        Spacer(modifier = Modifier.size(5.dp))

        Button(
            onClick = { onButtonClick(text) },
            enabled = type.isValid(text),
            modifier = Modifier.weight(0.5f)
        ) {
            Text(
                type.buttonText,
                textAlign = TextAlign.Center
            )
        }
    }
}
