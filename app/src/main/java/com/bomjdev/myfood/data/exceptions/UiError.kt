package com.bomjdev.myfood.data.exceptions

open class UiError(val type: UiErrorType,
                   val message: String)

enum class UiErrorType {
    INVALID_DATA, BAD_REQUEST
}