package com.example.repository.data_source

import com.example.cache.AppDatabase
import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import com.example.domain.utils.Resource
import com.example.network.ApiService
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class UserRepositoryImpl(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
): UserRepository {

    private val userDao = appDatabase.userDao()

    override suspend fun getUsers(fetchFromRemote: Boolean): Flow<Resource<List<User>>> = flow {
        emit(Resource.Loading(true))
        val usersEntity = userDao.getUsersFromDB()
        emit(Resource.Success(data = usersEntity.map { it.toDomain() }))

        val dbIsEmpty = usersEntity.isEmpty()
        val shouldFetchFromRemote = !dbIsEmpty && !fetchFromRemote
        if (shouldFetchFromRemote) {
            emit(Resource.Loading(false))
            return@flow
        }
        try {
           val userDto = apiService.getUsers()
            userDao.deleteUsersFromDB()
            userDao.insertUserToDB(userDto.toEntity(1L))
            emit(Resource.Success(data = userDao.getUsersFromDB().map { it.toDomain() }))
            emit(Resource.Loading(false))
        } catch (e: IOException) {
            println(e.message)
            emit(Resource.Error(message = "IO Error"))
        }
    }

    override suspend fun getUserById(userId: Long): Flow<Resource<User>> {
        TODO("Not yet implemented")
    }
}