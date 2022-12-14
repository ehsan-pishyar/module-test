package com.example.moduletest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.moduletest.navigation.Graph.AUTH
import com.example.moduletest.navigation.Graph.MAIN
import com.example.moduletest.navigation.Graph.ROOT
import com.example.moduletest.navigation.Graph.START
import com.example.moduletest.screens.auth.ForgotPasswordScreen
import com.example.moduletest.screens.auth.LoginScreen
import com.example.moduletest.screens.auth.RegisterScreen
import com.example.moduletest.screens.main.HomeScreen
import com.example.moduletest.screens.main.ProfileScreen
import com.example.moduletest.screens.main.SearchScreen
import com.example.moduletest.screens.start.SplashScreen
import com.example.moduletest.screens.start.WelcomeScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        route = ROOT,
        navController = navController,
        startDestination = StartScreens.SplashScreen.route
    ) {

        startNavigation(navController = navController)
        authNavigation(navController = navController)
        mainNavigation(navController = navController)

        // Group of Screens: Start Screens
        navigation(
            route = START,
            startDestination = StartScreens.SplashScreen.route
        ) {
            composable(route = StartScreens.SplashScreen.route) {
                SplashScreen()
            }
            composable(route = StartScreens.WelcomeScreen.route) {
                WelcomeScreen()
            }
        }

        // Group of Screens: Auth Screens
        navigation(
            route = AUTH,
            startDestination = AuthScreens.LoginScreen.route
        ) {
            composable(route = AuthScreens.LoginScreen.route) {
                LoginScreen()
            }
            composable(route = AuthScreens.RegisterScreen.route) {
                RegisterScreen()
            }
            composable(route = AuthScreens.ForgotPasswordScreen.route) {
                ForgotPasswordScreen()
            }
        }

        // Group of Screens: Main Screens
        navigation(
            route = MAIN,
            startDestination = MainScreens.HomeScreen.route
        ) {
            composable(route = MainScreens.HomeScreen.route) {
                HomeScreen()
            }
            composable(route = MainScreens.SearchScreen.route) {
                SearchScreen()
            }
            composable(route = MainScreens.ProfileScreen.route) {
                ProfileScreen()
            }
        }
    }
}

fun NavGraphBuilder.startNavigation(navController: NavHostController) {
    navigation(
        route = START,
        startDestination = StartScreens.SplashScreen.route
    ) {
        composable(route = StartScreens.SplashScreen.route) {
            SplashScreen()
        }
        composable(route = StartScreens.WelcomeScreen.route) {
            WelcomeScreen()
        }
    }
}

fun NavGraphBuilder.authNavigation(navController: NavHostController) {
    navigation(
        route = AUTH,
        startDestination = AuthScreens.LoginScreen.route
    ) {
        composable(route = AuthScreens.LoginScreen.route) {
            LoginScreen()
        }
        composable(route = AuthScreens.RegisterScreen.route) {
            RegisterScreen()
        }
        composable(route = AuthScreens.ForgotPasswordScreen.route) {
            ForgotPasswordScreen()
        }
    }
}

fun NavGraphBuilder.mainNavigation(navController: NavHostController) {
    navigation(
        route = MAIN,
        startDestination = AuthScreens.LoginScreen.route
    ) {
        composable(route = AuthScreens.LoginScreen.route) {
            LoginScreen()
        }
        composable(route = AuthScreens.RegisterScreen.route) {
            RegisterScreen()
        }
        composable(route = AuthScreens.ForgotPasswordScreen.route) {
            ForgotPasswordScreen()
        }
    }
}

object Graph {
    const val ROOT = "root"
    const val START = "start"
    const val AUTH = "auth"
    const val MAIN = "main"
}