package com.example.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alarmFunction()
    }

    private fun alarmFunction() {
        val am: AlarmManager = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val i = Intent(this, ActivityA::class.java)
        val pi = PendingIntent.getBroadcast(this, 0, i, 0)
        val i2 = Intent(this, ActivityB::class.java)
        val pi2 = PendingIntent.getActivity(this, 0, i2, 0)

        val ac = AlarmManager.AlarmClockInfo(
            System.currentTimeMillis() + 60000,
            pi2
        )
        Log.d("AAA", "Setting Alarm")
        am.setAlarmClock(ac, pi)
        Log.d("AAA", "Alarm is set")
    }
}
