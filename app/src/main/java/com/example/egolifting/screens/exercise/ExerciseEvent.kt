package com.example.egolifting.screens.exercise

import com.example.egolifting.data.entities.Exercise

sealed class ExerciseEvent {
    data class DeleteExercise(val exercise: Exercise): ExerciseEvent()
    data object OnAddExerciseClick: ExerciseEvent()
}