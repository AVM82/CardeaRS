package org.rs.cardears.core

sealed class Response {
    data class Loading(var loading: Boolean) : Response()
    data class Error(var errorMes: String) : Response()
    data class Success<T>(val data: T) : Response()
    object Idle : Response()
}
