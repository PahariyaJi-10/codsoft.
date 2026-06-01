package com.divyansh.alarmclockapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.divyansh.alarmclockapp.ui.HomeScreen
import com.divyansh.alarmclockapp.ui.theme.AlarmClockAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            AlarmClockAppTheme {

                HomeScreen()

            }
        }
    }
}