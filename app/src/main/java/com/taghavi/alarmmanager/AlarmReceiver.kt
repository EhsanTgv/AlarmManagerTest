package com.taghavi.alarmmanager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // Is triggered when alarm goes off, i.e. receiving a system broadcast
        if (intent.action == "FOO_ACTION") {
            val fooString = intent.getStringExtra("KEY_FOO_STRING")
            Toast.makeText(context, fooString, Toast.LENGTH_LONG).show()
            Log.i("MyTestTag", fooString!!)
        }
    }
}