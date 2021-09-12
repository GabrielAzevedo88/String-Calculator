package com.mube.stringcalculator.domain.usecase

import com.mube.stringcalculator.utils.extensions.clearNewLines
import com.mube.stringcalculator.utils.extensions.toIntOrZero

private const val DELIMITER = ","

class CalculatorUseCaseImp : CalculatorUseCase {

    override fun add(inputValue: String): Int {
        var sum = 0

        if (inputValue.isNotBlank()) {
            val numbers = inputValue
                .clearNewLines()
                .split(DELIMITER)

            numbers.forEach { number ->
                sum += number.trim().toIntOrZero()
            }
        }

        return sum
    }
}