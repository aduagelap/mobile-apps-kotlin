package org.company.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import moe.tlaster.precompose.navigation.Navigator


class Home {
    @Composable
    fun HomeScreen(navigator: Navigator) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .windowInsetsPadding(WindowInsets.safeDrawing),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = ("Welcome")
                )

                Button(
                    onClick = { navigator.navigate("/login") },
                    colors = ButtonDefaults.buttonColors(Color(0xff00a2ff)),
                ) {
                    Text("Home")
                }

                Button(
                    onClick = { navigator.navigate("/itemdetail") },
                    colors = ButtonDefaults.buttonColors(Color(0xff00a2ff)),
                ) {
                    Text("Item Detail")
                }
            }
        }
    }
}