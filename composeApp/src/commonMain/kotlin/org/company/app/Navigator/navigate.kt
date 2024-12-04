package org.company.app.Navigator

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import org.company.app.components.DialogLogin
import org.company.app.components.Home
import org.company.app.components.ItemDetail
import org.company.app.route.Route


class Navigation(private val navigator: Navigator) {
    @Composable
    fun Navigator() {
        PreComposeApp() {
            MaterialTheme {
                NavHost(
                    navigator = navigator,
                    initialRoute = "/itemdetail"
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
                    ) {
                        Home().HomeScreen(navigator)
                    }

                    // route item detail
                    scene(
                        route = Route.ItemDetail.route,
                        navTransition = NavTransition()
                    ) {
                        ItemDetail().ItemDetailScreen(navigator)
                    }
                }
            }
        }
    }
}