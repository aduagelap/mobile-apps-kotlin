package org.company.app.route

enum class Route(val route:String) {
    Home("/home/{username}"),
    Login("/login"),
    ItemDetail("/itemdetail"),
    Bluetooth("/bluetooth"),
    Location("/location"),
    InternetConnetion("/internet"),
}