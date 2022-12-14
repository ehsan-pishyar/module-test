package com.example.splash.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.splash.SplashScreen

private const val SPLASH_NAVIGATION_ROUTE = "splash_route"

fun NavController.navigateToSplashScreen(navOptions: NavOptions?) {
    this.navigate(route = SPLASH_NAVIGATION_ROUTE, navOptions = navOptions)
}

fun NavGraphBuilder.splashScreen() {
    composable(route = SPLASH_NAVIGATION_ROUTE) {
        SplashScreen()
    }
}