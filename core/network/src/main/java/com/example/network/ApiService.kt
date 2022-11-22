package com.example.network

import com.example.network.models.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/users")
    suspend fun getUsers(): UserDto

    @GET("/users/{id}")
    suspend fun getUserById(@Path("id") id: Long): UserDto
}