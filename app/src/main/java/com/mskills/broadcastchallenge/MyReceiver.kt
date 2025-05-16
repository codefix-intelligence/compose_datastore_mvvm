package com.mskills.broadcastchallenge

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.util.Log
import androidx.core.content.edit
import com.mskills.broadcastchallenge.viewModels.BatteryViewModel

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.

        val battLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)

        Log.d("MyReceiver", "Battery Level changed: $battLevel")

        // save it to Preference DataStore

        val vModel = BatteryViewModel(context)
        vModel.updateBatteryLevel(battLevel)
    }
}