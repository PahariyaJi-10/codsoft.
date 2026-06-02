package com.divyansh.alarmclockapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.divyansh.alarmclockapp.ui.theme.AlarmClockAppTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            AlarmClockAppTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route
                ) {

                    composable(Screen.Home.route) {
                        HomeScreen(navController)
                    }

                    composable(Screen.AddAlarm.route) {
                        AddAlarmScreen()
                    }
                }
            }
        }
    }
}
