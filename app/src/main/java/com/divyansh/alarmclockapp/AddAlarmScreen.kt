package com.divyansh.alarmclockapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddAlarmScreen() {

    var hour by remember { mutableStateOf("07") }
    var minute by remember { mutableStateOf("00") }
    var label by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Set Alarm",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row {

            OutlinedTextField(
                value = hour,
                onValueChange = { hour = it },
                label = { Text("Hour") },
                modifier = Modifier.width(120.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            OutlinedTextField(
                value = minute,
                onValueChange = { minute = it },
                label = { Text("Minute") },
                modifier = Modifier.width(120.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = label,
            onValueChange = { label = it },
            label = { Text("Alarm Label") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                // Save Alarm later
            }
        ) {
            Text("Save Alarm")
        }
    }
}