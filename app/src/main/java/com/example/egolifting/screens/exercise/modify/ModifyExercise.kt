package com.example.egolifting.screens.exercise.modify

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.egolifting.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModifyExercise(
    viewModel: ModifyExerciseViewModel = hiltViewModel(),
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "New Exercise") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Screen.Exercises.route)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(ModifyExerciseEvent.OnSaveSaveClick)
            }) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null
                )
            }
        },
        content = {padding ->
            Column(modifier = Modifier.padding(padding)) {
                TextField(
                    value = viewModel.name,
                    onValueChange = {
                        viewModel.onEvent(ModifyExerciseEvent.OnNameChange(it))
                    },
                    placeholder = {
                        Text(text = "Add Name")
                    }
                )
                TextField(
                    value = viewModel.muscleGroup,
                    onValueChange = {
                        viewModel.onEvent(ModifyExerciseEvent.OnMuscleGroupChange(it))
                    },
                    placeholder = {
                        Text(text = "Add Muscle Group")
                    }
                )
            }
        }
    )
}