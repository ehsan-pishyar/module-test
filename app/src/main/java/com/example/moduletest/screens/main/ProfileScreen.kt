package com.example.moduletest.screens.main

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(name = "Profile")
@Composable
fun ProfileScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Profile Screen",
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(50.dp))

            Button(onClick = { Log.e("CLICKED: ", "Go to Home Screen")}) {
                Text(
                    text = "Go to Home"
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Button(onClick = {Log.e("CLICKED: ", "Go to Search Screen")}) {
                Text(
                    text = "Go to Search"
                )
            }
        }
    }
}