package com.divyansh.alarmclockapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState

var showTimePicker by remember { mutableStateOf(false) }

val timePickerState = rememberTimePickerState(
    initialHour = 7,
    initialMinute = 0,
    is24Hour = false
)
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AddAlarmScreen() {

    var label by remember { mutableStateOf("") }
    var vibration by remember { mutableStateOf(true) }

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
                timePickerState.hour,
                timePickerState.minute
            ),
            fontSize = 48.sp
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                showTimePicker = true
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

        Text("Repeat Days")

        Spacer(modifier = Modifier.height(8.dp))

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            days.forEach { day ->

                FilterChip(
                    selected = day in selectedDays,

                    onClick = {

                        if (day in selectedDays)
                            selectedDays.remove(day)
                        else
                            selectedDays.add(day)

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

            Spacer(modifier = Modifier.weight(1f))

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
                // Save later
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Save Alarm")
        }
    }
    if (showTimePicker) {

        AlertDialog(
            onDismissRequest = {
                showTimePicker = false
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        showTimePicker = false
                    }
                ) {
                    Text("OK")
                }
            },

            dismissButton = {

                TextButton(
                    onClick = {
                        showTimePicker = false
                    }
                ) {
                    Text("Cancel")
                }
            },

            text = {
                TimePicker(
                    state = timePickerState
                )
            }
        )
    }
}