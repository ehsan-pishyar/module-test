package com.example.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User_Table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val name: String?,
    val email: String?
)
