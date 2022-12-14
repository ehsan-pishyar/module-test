package com.example.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val profileNavigationRoute = "profile_route"

fun NavController.navigateToProfile(navOptions: NavOptions? = null) {
    this.navigate(route = profileNavigationRoute, navOptions = navOptions)
}

fun NavGraphBuilder.profileScreen() {
    composable(route = profileNavigationRoute) {
    }
}