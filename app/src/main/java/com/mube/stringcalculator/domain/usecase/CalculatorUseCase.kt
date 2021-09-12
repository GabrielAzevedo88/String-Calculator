package com.mube.stringcalculator.domain.usecase

import com.mube.stringcalculator.domain.model.InputResult

interface CalculatorUseCase {

    fun add(inputValue: String): InputResult

}