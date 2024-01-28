package com.example.egolifting.screens.exercise.modify

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.egolifting.data.entities.Exercise
import com.example.egolifting.data.repositories.ExerciseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ModifyExerciseViewModel @Inject constructor(
    private val repository: ExerciseRepository
): ViewModel() {
    var exercise by mutableStateOf<Exercise?>(null)
        private set
    var name by mutableStateOf("")
        private set
    var muscleGroup by mutableStateOf("")
        private set

    fun onEvent(event: ModifyExerciseEvent) {
        when(event) {
            is ModifyExerciseEvent.OnNameChange -> {
                name = event.name
            }
            is ModifyExerciseEvent.OnMuscleGroupChange -> {
                muscleGroup = event.muscleGroup
            }
            is ModifyExerciseEvent.OnSaveSaveClick -> {
                viewModelScope.launch {
                    if (name.isBlank()) {
                        return@launch
                    }
                    repository.insertExercise(Exercise(
                        name = name,
                        muscleGroup = muscleGroup
                    ))
                }
            }
        }
    }
}