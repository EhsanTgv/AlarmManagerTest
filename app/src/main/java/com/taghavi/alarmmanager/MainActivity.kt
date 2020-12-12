package com.taghavi.alarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


// Get AlarmManager instance
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

// Intent part
        val intent = Intent(this, AlarmReceiver::class.java)
        intent.action = "FOO_ACTION"
        intent.putExtra("KEY_FOO_STRING", "Medium AlarmManager Demo")

        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)

// Alarm time
        val ALARM_DELAY_IN_SECOND = 30
        val alarmTimeAtUTC = System.currentTimeMillis() + ALARM_DELAY_IN_SECOND * 1_000L

// Set with system Alarm Service
// Other possible functions: setExact() / setRepeating() / setWindow(), etc
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, alarmTimeAtUTC, pendingIntent)
        }
    }
}