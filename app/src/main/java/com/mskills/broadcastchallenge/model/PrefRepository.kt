package com.mskills.broadcastchallenge.model

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.batteryDataStore by preferencesDataStore("batteryStore")

val batteryLevelKey = intPreferencesKey("level")

class PrefRepository(val ctx: Context) {

    // Preference Data Store

    suspend fun saveBatteryLevel(value: Int){
        ctx.batteryDataStore.edit {
            it[batteryLevelKey] = value
        }
    }

    // read data back

    fun getBatteryLevel(): Flow<Int>{
        return ctx.batteryDataStore.data.map {
            it[batteryLevelKey] ?: 0
        }
    }

}