package com.divyansh.alarmclockapp

import android.app.TimePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AddAlarmScreen(
    navController: NavController
) {

    val context = LocalContext.current

    var selectedHour by remember {
        mutableStateOf(7)
    }

    var selectedMinute by remember {
        mutableStateOf(0)
    }

    var label by remember {
        mutableStateOf("")
    }

    var vibration by remember {
        mutableStateOf(true)
    }

    val selectedDays = remember {
        mutableStateListOf<String>()
    }

    val days = listOf(
        "Mon", "Tue", "Wed",
        "Thu", "Fri", "Sat", "Sun"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Set Alarm",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = String.format(
                "%02d:%02d",
                selectedHour,
                selectedMinute
            ),
            fontSize = 48.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                TimePickerDialog(
                    context,
                    { _, hour, minute ->

                        selectedHour = hour
                        selectedMinute = minute

                    },
                    selectedHour,
                    selectedMinute,
                    false
                ).show()

            }
        ) {
            Text("Pick Time")
        }

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = label,
            onValueChange = { label = it },
            label = {
                Text("Alarm Label")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Repeat Days",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            days.forEach { day ->

                FilterChip(
                    selected = day in selectedDays,

                    onClick = {

                        if (day in selectedDays) {
                            selectedDays.remove(day)
                        } else {
                            selectedDays.add(day)
                        }

                    },

                    label = {
                        Text(day)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text("Vibration")

            Spacer(
                modifier = Modifier.weight(1f)
            )

            Switch(
                checked = vibration,
                onCheckedChange = {
                    vibration = it
                }
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {

                AlarmRepository.alarms.add(
                    Alarm(
                        hour = selectedHour,
                        minute = selectedMinute,
                        label = label
                    )
                )
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Alarm")
        }
    }
}