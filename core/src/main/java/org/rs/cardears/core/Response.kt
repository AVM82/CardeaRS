package org.rs.cardears.core

sealed class Response<T> {
    data class Loading(var loading: Boolean) : Response<Boolean>()
    data class Error(var errorMes: String) : Response<String>()
    data class Success<T: Any>(val data: T) : Response<T>()
    object Idle : Response<Nothing>()
}
