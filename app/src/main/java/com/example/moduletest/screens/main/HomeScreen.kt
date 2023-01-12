package com.example.moduletest.screens.main

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.moduletest.navigation.BottomBarScreens
import androidx.compose.material.*
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = { BottomBar(navHostController = navController) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Home Screen",
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable {

                }
            )

            Spacer(modifier = Modifier.height(50.dp))

            Button(
                onClick = { Log.e("CLICKED: ", "Go to Profile Screen") }
            ) {
                Text(
                    text = "Go to Profile"
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Button(
                onClick = { Log.e("CLICKED: ", "Go to Search Screen") }
            ) {
                Text(
                    text = "Go to Search"
                )
            }
        }
    }
}

@Composable
fun BottomBar(navHostController: NavHostController) {
    val screens = listOf(
        BottomBarScreens.HomeScreen,
        BottomBarScreens.SearchScreen,
        BottomBarScreens.ProfileScreen
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any {
        it.route == currentDestination?.route
    }
    if (bottomBarDestination) {
        BottomNavigation {
            screens.forEach { screens ->
                AddItem(
                    screens = screens,
                    currentDestination = currentDestination,
                    navController = navHostController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screens: BottomBarScreens,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screens.title)
        },
        icon = {
            Icon(
                imageVector = screens.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screens.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screens.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}