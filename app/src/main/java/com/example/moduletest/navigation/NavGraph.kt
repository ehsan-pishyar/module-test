package com.example.moduletest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.home.navigation.navigation.homeNavigationRoute
import com.example.home.navigation.navigation.homeScreen
import com.example.profile.navigation.profileScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    onBackClick: () -> Unit,
    modifier: Modifier
) {

    NavHost(
        navController = navController,
        startDestination = homeNavigationRoute
    ) {
        homeScreen()
        profileScreen()
    }
}