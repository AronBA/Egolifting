package com.example.egolifting.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MuscleGroup(
    val name: String,
    @PrimaryKey val id: Int? = null
)