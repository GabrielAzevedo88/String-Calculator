package com.mube.stringcalculator.domain.model

sealed class InputResult

data class Success(val value: Int) : InputResult()
data class Error(val message: String) : InputResult()