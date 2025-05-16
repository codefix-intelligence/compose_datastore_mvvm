package com.mskills.broadcastchallenge.viewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mskills.broadcastchallenge.model.PrefRepository
import kotlinx.coroutines.launch

class BatteryViewModel(ctx: Context) : ViewModel() {

    val repo = PrefRepository(ctx)

    val level = repo.getBatteryLevel()

    fun updateBatteryLevel(level: Int){
        viewModelScope.launch {
            repo.saveBatteryLevel(level)
        }
    }
}

