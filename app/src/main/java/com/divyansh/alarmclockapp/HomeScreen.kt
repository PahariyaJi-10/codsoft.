package com.divyansh.alarmclockapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAlarm
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*
import androidx.navigation.NavController
import android.app.TimePickerDialog
import androidx.compose.ui.platform.LocalContext

@Composable
fun HomeScreen(
    navController: NavController
) {

    var currentTime by remember {
        mutableStateOf(Date())
    }

    LaunchedEffect(Unit) {
        while (true) {
            currentTime = Date()
            delay(1000)
        }
    }

    val time =
        SimpleDateFormat(
            "hh:mm:ss a",
            Locale.getDefault()
        ).format(currentTime)

    val date =
        SimpleDateFormat(
            "EEEE, dd MMM yyyy",
            Locale.getDefault()
        ).format(currentTime)

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(
                        Screen.AddAlarm.route
                    )
                }
            ) {
                Icon(
                    Icons.Default.AddAlarm,
                    contentDescription = "Add Alarm"
                )
            }
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary
                        )
                    )
                )
                .padding(padding)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(50.dp))

                Text(
                    text = getGreeting(),
                    fontSize = 26.sp,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = time,
                    fontSize = 48.sp,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = date,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                Spacer(modifier = Modifier.height(40.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = "Next Alarm",
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(
                            text = "No Alarm Set",
                            fontSize = 24.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = "My Alarms",
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        if (AlarmRepository.alarms.isEmpty()) {

                            Text(
                                text = "No alarms available"
                            )

                        } else {

                            AlarmRepository.alarms.forEach { alarm ->

                                Spacer(
                                    modifier = Modifier.height(8.dp)
                                )

                                Text(
                                    text = String.format(
                                        "%02d:%02d",
                                        alarm.hour,
                                        alarm.minute
                                    )
                                )

                                Text(
                                    text = alarm.label
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

fun getGreeting(): String {

    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

    return when {
        hour < 12 -> "Good Morning ☀️"
        hour < 17 -> "Good Afternoon 🌤️"
        else -> "Good Evening 🌙"
    }
}