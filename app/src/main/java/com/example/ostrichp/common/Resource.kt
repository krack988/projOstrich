package com.example.ostrichp.common

sealed class Resource<out T> {

    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val exception: CallErrors) : Resource<Nothing>()
    object Loading : Resource<Nothing>()

}