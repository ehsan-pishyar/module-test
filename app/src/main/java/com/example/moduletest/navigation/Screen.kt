package com.example.moduletest.navigation

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
