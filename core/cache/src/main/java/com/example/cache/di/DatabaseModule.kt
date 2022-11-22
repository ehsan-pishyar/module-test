package com.example.cache.di

import android.content.Context
import androidx.room.Room
import com.example.cache.AppDatabase
import com.example.cache.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun addDatabaseProvider(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "test_database"
        )
            .build()

    @Provides
    @Singleton
    fun userDaoProvider(database: AppDatabase): UserDao = database.userDao()
}