package org.company.app

import androidx.compose.runtime.*
import moe.tlaster.precompose.navigation.rememberNavigator
import org.company.app.Navigator.Navigation
import org.company.app.theme.AppTheme

@Composable
internal fun App() = AppTheme {
//    Default().homeScreen()
//    Home().homeScreen()
//    DialogLogin().HomeScreen()
    val navigator = rememberNavigator()
    Navigation(navigator).Navigator()
}

