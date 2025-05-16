package com.mskills.broadcastchallenge.view

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mskills.broadcastchallenge.viewModels.BatteryViewModel

@Composable
fun BatteryScreen(modifier: Modifier = Modifier) {

    val ctx = LocalContext.current

    val vModel: BatteryViewModel = viewModel {
        BatteryViewModel(ctx)
    }

    // make it state - recomposition will happen when value changed
    val batteryLevel = vModel.level.collectAsState(0)

    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text("Battery Level : ${batteryLevel.value}", fontSize = 24.sp)
    }

}