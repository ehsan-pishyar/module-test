package com.example.moduletest.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class StartScreens(val route: String) {
    object SplashScreen: StartScreens(route = "splash")
    object WelcomeScreen: StartScreens(route = "welcome")
}

sealed class AuthScreens(val route: String) {
    object LoginScreen: AuthScreens(route = "login")
    object RegisterScreen: AuthScreens(route = "register")
    object ForgotPasswordScreen: AuthScreens(route = "forgot_password")
}

sealed class MainScreens(val route: String) {
    object HomeScreen: MainScreens(route = "home")
    object ProfileScreen: MainScreens(route = "profile")
    object SearchScreen: MainScreens(route = "search")

    object DetailsScreen: MainScreens(route = "details")
}

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector
) {

    object HomeScreen: BottomBarScreen(
        route = "home_route",
        title = "Home",
        icon = Icons.Default.Home,
        selectedIcon = Icons.Filled.Home
    )

    object ProfileScreen: BottomBarScreen(
        route = "profile_route",
        title = "Profile",
        icon = Icons.Default.Person,
        selectedIcon = Icons.Filled.Person
    )

    object SearchScreen: BottomBarScreen(
        route = "search_route",
        title = "Search",
        icon = Icons.Default.Search,
        selectedIcon = Icons.Filled.Search
    )
}
