package com.iperovv.vkcourseproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.iperovv.vkcourseproject.ui.components.IntentRow
import com.iperovv.vkcourseproject.ui.theme.VKCourseProjectTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKCourseProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(Modifier
                        .padding(innerPadding)
                        .padding(horizontal = 8.dp))
                }
            }
        }

    }
}

@Composable
private fun Content(modifier: Modifier) {
    val inputValues = remember { mutableStateMapOf<IntentType, String>() }
    val context = LocalContext.current

    Column(modifier.fillMaxSize(), Arrangement.Center) {
        IntentType.entries.forEach { type ->
            val text = inputValues[type] ?: ""
            IntentRow(
                modifier = Modifier.fillMaxWidth(),
                type = type,
                text = text,
                onTextChange = { inputValues[type] = it },
                onButtonClick = { type.onButtonClick(context, it) }
            )
            Spacer(modifier = Modifier.size(5.dp))
        }
    }
}
