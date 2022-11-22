package com.example.domain.utils

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>(loading: Boolean): Resource<T>()
    class Success<T>(data: T? = null): Resource<T>(data = data)
    class Error<T>(data: T? = null, message: String? = null): Resource<T>(data = null, message = message)
}
