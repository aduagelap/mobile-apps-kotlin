package org.company.app.components

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import chaintech.network.connectivitymonitor.ConnectivityMonitor
import chaintech.network.connectivitymonitor.ConnectivityStatus


class InternetConnection {
    @Composable
    fun ConnectionView() {
        // check connection v2
        val connectivityMonitor = ConnectivityMonitor.instance
//        connectivityMonitor.startMonitoring()
        var checkStatus by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (checkStatus) {
                ConnectivityStatusView(connectivityMonitor)
            }
            Button(onClick = {
                checkStatus = true
            }) {
                Text("Check Connection")
            }
        }
    }
}

@Composable
fun ConnectivityStatusView(connectivityMonitor: ConnectivityMonitor) {
    connectivityMonitor.refresh()
    val status by connectivityMonitor.status.collectAsState()
    println("clicked $status")
    when (status) {
        ConnectivityStatus.CONNECTED,
        ConnectivityStatus.CONNECTED_VIA_CELLULAR,
        ConnectivityStatus.CONNECTED_VIA_WIFI -> {
//             Show connected UI
            println("connected")
        }

        ConnectivityStatus.NOT_CONNECTED,
        ConnectivityStatus.CONNECTED_VIA_CELLULAR_WITHOUT_INTERNET,
        ConnectivityStatus.CONNECTED_VIA_WIFI_WITHOUT_INTERNET -> {
            // Show disconnected UI
            println("disconnected")
        }

        ConnectivityStatus.DETERMINING -> {
            println("loading")
            // Show loading or determining UI
        }
    }
}
