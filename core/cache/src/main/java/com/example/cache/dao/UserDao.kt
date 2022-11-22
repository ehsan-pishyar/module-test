package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.models.UserEntity
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserToDB(userEntity: UserEntity)

    @Query("SELECT * FROM `User_Table`")
    suspend fun getUsersFromDB(): List<UserEntity>

    @Query("SELECT * FROM `User_Table` WHERE id = :userId")
    suspend fun getUserByIdFromDB(userId: Long): UserEntity

    @Delete
    suspend fun deleteUsersFromDB()
}