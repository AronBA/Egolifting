package com.example.egolifting.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector, val title: String) {
    data object Profile : Screen("profile", Icons.Filled.Person, "Profile")
    data object History : Screen("history", Icons.Filled.DateRange, "History")
    data object Workout : Screen("workout", Icons.Filled.Add, "Workout")
    data object Exercises : Screen("exercises", Icons.Filled.Call, "Exercises")
}

val items = listOf(
    Screen.Profile,
    Screen.History,
    Screen.Workout,
    Screen.Exercises
)