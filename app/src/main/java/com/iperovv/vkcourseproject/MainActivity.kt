package com.iperovv.vkcourseproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iperovv.vkcourseproject.navigation.Screen
import com.iperovv.vkcourseproject.ui.screens.appdetails.AppDetailsScreen
import com.iperovv.vkcourseproject.ui.screens.applist.AppListScreen
import com.iperovv.vkcourseproject.ui.theme.VKCourseProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKCourseProjectTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.AppListScreen
                ) {
                    composable<Screen.AppListScreen> {
                        AppListScreen(
                            onAppClick = {
                                navController.navigate(Screen.AppDetailsScreen)
                            }
                        )
                    }
                    composable<Screen.AppDetailsScreen> {
                        AppDetailsScreen(
                            onNavigateBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}
