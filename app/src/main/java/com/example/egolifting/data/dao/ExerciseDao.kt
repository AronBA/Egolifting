package com.example.egolifting.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import com.example.egolifting.data.entities.Exercise

@Dao
interface ExerciseDao {
    @Upsert
    suspend fun insertExercise(exercise: Exercise)
    @Delete
    suspend fun deleteExercise(exercise: Exercise)
    @Query("SELECT * FROM exercise WHERE id = :id")
    suspend fun getExerciseById(id: Int): Exercise?
    @Query("SELECT * FROM exercise")
    fun getExercises(): Flow<List<Exercise>>
}