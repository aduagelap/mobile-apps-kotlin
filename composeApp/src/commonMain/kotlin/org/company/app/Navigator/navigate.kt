package org.company.app.Navigator

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.transition.NavTransition
import org.company.app.components.Bluetooth
import org.company.app.components.DialogLogin
import org.company.app.components.Home
import org.company.app.components.InternetConnection
import org.company.app.components.ItemDetail
import org.company.app.components.Location
import org.company.app.route.Route


class Navigation(private val navigator: Navigator) {
    @Composable
    fun Navigator() {
        PreComposeApp() {
            MaterialTheme {
                NavHost(
                    navigator = navigator,
                    initialRoute = "/login"
                ) {
                    // route login
                    scene(
                        route = Route.Login.route,
                        navTransition = NavTransition()
                    ) {
                        DialogLogin().LoginScreen(navigator)
                    }

                    // route home
                    scene(
                        route = Route.Home.route,
                        navTransition = NavTransition()
                    ) { backStackEntry ->
                        var name = backStackEntry.pathMap["username"]
                        println(name)
                        Home().HomeScreen(navigator)
                    }

                    // route item detail
                    scene(
                        route = Route.ItemDetail.route,
                        navTransition = NavTransition()
                    ) {
                        ItemDetail().ItemDetailScreen(navigator)
                    }

                    // route bluetooth
                    scene(
                        route = Route.Bluetooth.route,
                        navTransition = NavTransition()
                    ) {
                        Bluetooth().BluetoothScreen(navigator)
                    }

                    // route location
                    scene(
                        route = Route.Location.route,
                        navTransition = NavTransition()
                    ) {
                        Location().LocationScreen(navigator, {}, {})
                    }

                    // route internet connection
                    scene(
                        route = Route.InternetConnetion.route,
                        navTransition = NavTransition()
                    ) {
                        InternetConnection().ConnectionView()
                    }
                }
            }
        }
    }
}