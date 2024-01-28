package com.example.egolifting.screens.exercise.modify

sealed class ModifyExerciseEvent {
    data class OnNameChange(val name: String): ModifyExerciseEvent()
    data class OnMuscleGroupChange(val muscleGroup: String): ModifyExerciseEvent()
    data object OnSaveSaveClick: ModifyExerciseEvent()
}