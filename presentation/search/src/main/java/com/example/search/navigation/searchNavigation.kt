package com.example.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val searchNavigationRoute = "search_route"

fun NavController.navigateToSearch(navOptions: NavOptions? = null) {
    this.navigate(route = searchNavigationRoute, navOptions = navOptions)
}

fun NavGraphBuilder.searchScreen() {
    composable(route = searchNavigationRoute) {
        //SearchScreen()
    }
}