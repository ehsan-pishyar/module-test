package com.example.repository.mappers

import com.example.cache.models.UserEntity
import com.example.network.models.UserDto

fun UserDto.toEntity(id: Long): UserEntity =
    UserEntity(
        id = id,
        this.name,
        this.email
    )