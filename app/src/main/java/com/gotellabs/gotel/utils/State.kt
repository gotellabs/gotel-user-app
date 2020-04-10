package com.gotellabs.gotel.utils


/**
 * Created by Enzo Lizama Paredes on 4/9/20.
 * Contact: lizama.enzo@gmail.com
 */

sealed class State<T> {
    class Loading<T> : State<T>()

    data class Success<T>(val data: T) : State<T>()

    data class Error<T>(val message: String) : State<T>()

    companion object {
        fun <T> loading() = Loading<T>()
        fun <T> success(data: T) = Success(data)
        fun <T> error(message: String) = Error<T>(message)
    }
}