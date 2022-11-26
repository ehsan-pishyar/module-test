package com.example.moduletest.navigation

sealed class Screen(val route: String) {
    object HomeScreen: Screen(route = "home_screen")
    object ProfileScreen: Screen(route = "profile_screen")
    object SearchScreen: Screen(route = "search_screen")
}
