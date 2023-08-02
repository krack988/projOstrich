package com.example.ostrichp.common

sealed class CallErrors {
    object ErrorEmptyData : CallErrors()
    object ErrorServer: CallErrors()
    data class ErrorException(val throwable: Throwable) : CallErrors()
}