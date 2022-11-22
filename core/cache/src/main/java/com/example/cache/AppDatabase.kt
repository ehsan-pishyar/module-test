package com.example.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cache.dao.UserDao
import com.example.cache.models.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}