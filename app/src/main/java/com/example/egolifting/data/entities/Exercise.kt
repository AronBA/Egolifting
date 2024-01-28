package com.example.egolifting.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Exercise(
    val name: String,
    val muscleGroup: String,
    @PrimaryKey val id: Int? = null
)