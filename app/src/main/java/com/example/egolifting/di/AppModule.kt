package com.example.egolifting.di

import android.app.Application
import androidx.room.Room
import com.example.egolifting.data.EgoliftingDatabase
import com.example.egolifting.data.repositories.ExerciseRepository
import com.example.egolifting.data.repositories.ExerciseRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideEgoliftingDatabase(app: Application): EgoliftingDatabase {
        return Room.databaseBuilder(
            app,
            EgoliftingDatabase::class.java,
            "egolifting_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideExerciseRepository(db: EgoliftingDatabase): ExerciseRepository {
        return ExerciseRepositoryImpl(db.exerciseDao)
    }
}