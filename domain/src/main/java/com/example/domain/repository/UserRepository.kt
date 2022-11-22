package com.example.domain.repository

import com.example.domain.model.User
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun getUsers(fetchFromRemote: Boolean): Flow<Resource<List<User>>>
    suspend fun getUserById(userId: Long): Flow<Resource<User>>
}