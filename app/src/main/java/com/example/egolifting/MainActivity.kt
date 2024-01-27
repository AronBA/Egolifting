package com.example.egolifting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.egolifting.navigation.items
import com.example.egolifting.screens.Exercises
import com.example.egolifting.screens.History
import com.example.egolifting.screens.Profile
import com.example.egolifting.screens.Workout
import com.example.egolifting.ui.theme.EgoliftingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EgoliftingTheme {
                val navController = rememberNavController()
                var currentPageIndex by rememberSaveable {
                    mutableIntStateOf(1)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Scaffold (
                        bottomBar = {
                            NavigationBar {
                                items.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = currentPageIndex == index,
                                        onClick = {
                                            currentPageIndex = index
                                            navController.navigate(item.route)
                                        },
                                        icon = { Icon(item.icon, contentDescription = item.title) },
                                        label = { Text(item.title) }
                                    )
                                }
                            }
},
                        content = {padding ->
                            NavHost(
                                navController = navController,
                                startDestination = items[currentPageIndex].route,
                                modifier = Modifier.padding(padding)
                            ) {
                                composable("profile") { Profile() }
                                composable("history") { History() }
                                composable("workout") { Workout() }
                                composable("exercises") { Exercises() }
                            }
                        }
                    )
                }
            }
        }
    }
}