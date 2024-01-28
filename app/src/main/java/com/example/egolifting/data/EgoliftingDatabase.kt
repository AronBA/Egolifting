package com.example.egolifting.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.egolifting.data.dao.ExerciseDao
import com.example.egolifting.data.entities.Exercise

@Database(
    entities = [Exercise::class],
    version = 1
)
abstract class EgoliftingDatabase: RoomDatabase() {
    abstract val exerciseDao: ExerciseDao
}