package com.example.furniturestore.core.presentation

import android.content.Context
import com.example.furniturestore.core.domain.util.NetworkError
import com.example.gemstore.R

fun NetworkError.toString(context:Context):String{
    val resid = when(this){
        NetworkError.RATE_LIMIT_EXCEEDED -> R.string.rate_limit_exceeded
        NetworkError.INVALID_REQUEST_PARAMS -> R.string.invalid_request_params
        NetworkError.RESOURCE_NOT_FOUND -> R.string.resource_not_found
        NetworkError.INTERNAL_SERVER_ERROR -> R.string.server_error
        NetworkError.NO_INTERNET ->  R.string.no_internet
        NetworkError.SERIALIZATION -> R.string.serialization
        NetworkError.TOO_MANY_REQUESTS -> R.string.too_many_requests
        NetworkError.REQUEST_TIMEOUT -> R.string.request_time_out
        NetworkError.UNKNOWN -> R.string.unknown
    }
    return context.getString(resid)
}