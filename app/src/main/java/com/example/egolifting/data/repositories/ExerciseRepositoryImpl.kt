package com.example.egolifting.data.repositories

import com.example.egolifting.data.dao.ExerciseDao
import com.example.egolifting.data.entities.Exercise
import kotlinx.coroutines.flow.Flow

class ExerciseRepositoryImpl(private val dao: ExerciseDao) : ExerciseRepository {
    override suspend fun insertExercise(exercise: Exercise) {
        return dao.insertExercise(exercise)
    }
    override suspend fun deleteExercise(exercise: Exercise) {
        return dao.deleteExercise(exercise)
    }
    override suspend fun getExerciseById(id: Int): Exercise? {
        return dao.getExerciseById(id)
    }
    override fun getTodos(): Flow<List<Exercise>> {
        return dao.getExercises()
    }
}