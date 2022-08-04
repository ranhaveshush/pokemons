package com.openweb.pokemons.state

sealed class Result<out T> {
    companion object {
        fun <T> loading() = LoadingResult<T>()
        fun <T> empty() = EmptyResult<T>()
        fun <T> success(data: T) = SuccessResult(data)
        fun <T> error(error: Throwable = IllegalStateException()) = ErrorResult<T>(error)
    }
}

class LoadingResult<T> : Result<T>()

class EmptyResult<T> : Result<T>()

data class SuccessResult<T>(val data: T) : Result<T>()

data class ErrorResult<T>(val error: Throwable) : Result<T>()
