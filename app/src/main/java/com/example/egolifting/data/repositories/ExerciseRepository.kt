package com.example.egolifting.data.repositories

import com.example.egolifting.data.entities.Exercise
import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {
    suspend fun insertExercise(exercise: Exercise)
    suspend fun deleteExercise(exercise: Exercise)
    suspend fun getExerciseById(id: Int): Exercise?
    fun getTodos(): Flow<List<Exercise>>
}