package com.example.egolifting.screens.exercise

import androidx.lifecycle.ViewModel
import com.example.egolifting.data.repositories.ExerciseRepository
import com.example.egolifting.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    private val repository: ExerciseRepository
): ViewModel() {
    val exercises = repository.getTodos()

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: ExerciseEvent) {
        when(event) {
            is ExerciseEvent.DeleteExercise -> {

            }
            is ExerciseEvent.OnAddExerciseClick -> {
                UiEvent.Navigate("workouts")
            }
        }
    }
}