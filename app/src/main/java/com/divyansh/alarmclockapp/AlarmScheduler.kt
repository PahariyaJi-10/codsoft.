package com.divyansh.alarmclockapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.divyansh.alarmclockapp.receiver.AlarmReceiver
import java.util.Calendar

object AlarmScheduler {

    fun scheduleAlarm(
        context: Context,
        hour: Int,
        minute: Int
    ) {

        val alarmManager =
            context.getSystemService(
                Context.ALARM_SERVICE
            ) as AlarmManager

        val intent = Intent(
            context,
            AlarmReceiver::class.java
        )

        val pendingIntent =
            PendingIntent.getBroadcast(
                context,
                hour * 100 + minute,
                intent,
                PendingIntent.FLAG_IMMUTABLE or
                        PendingIntent.FLAG_UPDATE_CURRENT
            )

        val calendar = Calendar.getInstance()

        calendar.set(
            Calendar.HOUR_OF_DAY,
            hour
        )

        calendar.set(
            Calendar.MINUTE,
            minute
        )

        calendar.set(
            Calendar.SECOND,
            0
        )

        if (calendar.timeInMillis <
            System.currentTimeMillis()
        ) {
            calendar.add(
                Calendar.DAY_OF_MONTH,
                1
            )
        }

        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            pendingIntent
        )
    }
}