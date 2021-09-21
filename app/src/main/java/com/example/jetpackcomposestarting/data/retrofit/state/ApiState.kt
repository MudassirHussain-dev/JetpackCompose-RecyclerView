package com.example.jetpackcomposestarting.data.retrofit.state

import com.example.jetpackcomposestarting.data.retrofit.Post

sealed class ApiState {
    class Success(val data: List<Post>) : ApiState()
    class Failure(val msg: Throwable) : ApiState()
    object Loading : ApiState()
    object Empty : ApiState()
}
/*sealed class ApiState<T>(val data: T? = null, val msg: Throwable? = null) {
    class Success<T>(data: T? = null) : ApiState<T>(data = data)
    class Failure<T>(msg: Throwable) : ApiState<T>(msg = msg)
    class Loading<T> : ApiState<T>()
    class Empty<T> : ApiState<T>()
}

sealed class Response<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : Response<T>(data = data)
    class Error<T>(message: String?, data: T? = null) : Response<T>(data = data, message = message)
    class Loading<T>(data: T? = null) : Response<T>(data = data)
}*/
