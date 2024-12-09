package org.company.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import org.company.app.Navigator.Navigation
import org.company.app.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    val navigator = rememberNavigator()
    Navigation(navigator).Navigator()
//    PreComposeApp() {
//        val navigator = rememberNavigator()
//        MaterialTheme {
//            NavHost (
//                navigator = navigator,
//                initialRoute = "/home"
//            ) {
//                scene(route = "/home") {
//                    var username by remember { mutableStateOf("") }
//                    Column(
//                        modifier = Modifier.fillMaxSize(),
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Center
//                    ) {
//                        Text(
//                            text = "Greet Me!",
//                            style = MaterialTheme.typography.headlineLarge
//                        )
//                        Spacer(modifier = Modifier.height(30.dp))
//                        TextField(
//                            value = username,
//                            maxLines = 1,
//                            label = { Text(text = "Enter your name") },
//                            onValueChange = { username = it }
//                        )
//                        Spacer(modifier = Modifier.height(30.dp))
//                        Button(
//                            onClick = {
//                                navigator.navigate(route = "/greeting/$username")
//                            }
//                        ) {
//                            Text(text = "GO!")
//                        }
//                    }
//                }
//                scene(route = "/greeting/{name}") { backStackEntry ->
//                    backStackEntry.path<String>("name")?.let { name ->
//                        Column(
//                            modifier = Modifier.fillMaxSize(),
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            verticalArrangement = Arrangement.Center
//                        ) {
//                            Text(
//                                text = name,
//                                style = MaterialTheme.typography.headlineLarge
//                            )
//                            Spacer(modifier = Modifier.height(30.dp))
//                            Button(onClick = navigator::goBack) {
//                                Text(text = "GO BACK!")
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
}

