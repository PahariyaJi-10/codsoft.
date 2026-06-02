package com.divyansh.alarmclockapp

sealed class Screen(val route: String) {

    object Home : Screen("home")

    object AddAlarm : Screen("add_alarm")
}