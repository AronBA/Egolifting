package com.example.egolifting.screens.exercise

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.egolifting.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercises(
    viewModel: ExerciseViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val exercises = viewModel.exercises.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            MediumTopAppBar(title = { Text(text = "Exercises") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screen.ModifyExercises.route)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        },
        content = {padding ->
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(exercises.value) { exercise ->
                    Row(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Column {
                            Text(text = exercise.name)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = exercise.muscleGroup)
                        }
                    }
                }
            }
        }
    )
}