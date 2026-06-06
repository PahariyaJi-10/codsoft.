# ⏰ Alarm Clock App

A modern Alarm Clock application built using **Kotlin** and **Jetpack Compose** for Android. The app allows users to create, manage, and schedule alarms with a clean Material 3 user interface.

# 🚀 Features

* Live Digital Clock
* Current Date Display
* Dynamic Greeting (Morning / Afternoon / Evening)
* Add New Alarms
* Time Picker for Alarm Selection
* Alarm Labels
* Repeat Days Selection UI
* Vibration Toggle UI
* Enable / Disable Alarms
* Delete Alarms
* Next Alarm Card
* Alarm Statistics Dashboard
* Alarm Notifications
* Alarm Sound Playback
* Automatic Alarm Stop after 15 Seconds
* Material 3 Design
* Jetpack Compose UI
* Navigation Component Integration

# 🛠️ Tech Stack

* Kotlin
* Jetpack Compose
* Material 3
* Navigation Compose
* AlarmManager
* BroadcastReceiver
* Notifications API
* Coroutines

# 📱 Screens

# Home Screen:

* Live Clock
* Current Date
* Greeting Message
* Next Alarm Card
* Alarm Statistics Card
* Alarm List

# Add Alarm Screen:

* Time Picker
* Alarm Label
* Repeat Days Selection
* Vibration Toggle
* Save Alarm

## 📂 Project Structure

```text
com.divyansh.alarmclockapp
│
├── MainActivity.kt
├── HomeScreen.kt
├── AddAlarmScreen.kt
├── Alarm.kt
├── AlarmRepository.kt
├── AlarmScheduler.kt
├── Screen.kt
│
├── receiver
│   └── AlarmReceiver.kt
│
└── data
    ├── AlarmEntity.kt
    ├── AlarmDao.kt
    └── AlarmDatabase.kt
```

## ⚙️ How It Works

1. User creates an alarm.
2. Alarm is stored in the app.
3. AlarmManager schedules the alarm.
4. AlarmReceiver receives the broadcast when the alarm time is reached.
5. A notification is displayed.
6. Alarm sound is played.
7. Alarm automatically stops after 15 seconds.



## 🔮 Future Improvements

* Snooze Feature
* Dismiss Action
* Room Database Persistence
* Edit Alarm
* Custom Alarm Sounds
* Dark Mode
* Alarm Countdown



GitHub: https://github.com/PahariyaJi-10

##For Clone Repo :-
git clone https://github.com/PahariyaJi-10/codsoft..git
---


