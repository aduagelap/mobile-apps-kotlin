package org.company.app

import androidx.compose.runtime.*
import org.company.app.components.Default
import org.company.app.theme.AppTheme
import org.company.app.components.Home

@Composable
internal fun App() = AppTheme {
//    Default().homeScreen()
    Home().homeScreen()
    // test2
}
