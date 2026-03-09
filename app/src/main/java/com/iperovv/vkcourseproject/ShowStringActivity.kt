package com.iperovv.vkcourseproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.iperovv.vkcourseproject.ui.theme.VKCourseProjectTheme

class ShowStringActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inputText = intent.getStringExtra("INPUT_TEXT") ?: "Nothing to show here"
        setContent {
            VKCourseProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(Modifier.padding(innerPadding), inputText)
                }
            }
        }
    }
}

@Composable
private fun Content(modifier: Modifier, text: String) {
    Box(modifier.fillMaxSize(), Alignment.Center) {
        Text(text)
    }
}