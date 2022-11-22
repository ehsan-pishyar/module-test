package com.example.repository.mappers

import com.example.cache.models.UserEntity
import com.example.domain.model.User

fun UserEntity.toDomain(): User =
    User(
        this.name,
        this.email
    )