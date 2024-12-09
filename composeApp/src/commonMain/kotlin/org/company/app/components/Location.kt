package org.company.app.components

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import moe.tlaster.precompose.navigation.Navigator


class Location {
    @Composable
    fun LocationScreen(
        navigator: Navigator,
        onPermissionGranted: () -> Unit,
        onPermissionDenied: () -> Unit
    ) {
        val locationPermissionLauncher =
            rememberLauncherForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissionMap ->
                println(permissionMap)
                val arePermissionsGranted = permissionMap.values.reduce { acc, next ->
                    acc && next
                }

                if (arePermissionsGranted) {
                    onPermissionGranted.invoke()
                    println("granted")
                } else {
                    onPermissionDenied.invoke()
                    println("denied")
                }
            }

        LaunchedEffect(Unit) {
            locationPermissionLauncher.launch(
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .windowInsetsPadding(WindowInsets.safeDrawing),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column {
                    Text(
                        text = ("Welcome Location")
                    )
                }

                Button(
                    onClick = { navigator.navigate("/login") },
                    colors = ButtonDefaults.buttonColors(Color(0xff00a2ff)),
                ) {
                    Text("Home")
                }
            }
        }
    }
}