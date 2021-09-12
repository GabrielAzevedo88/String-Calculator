package com.mube.stringcalculator.domain.model

sealed class InputResult

class Success(val value: Int) : InputResult()
class Error(val message: String) : InputResult()