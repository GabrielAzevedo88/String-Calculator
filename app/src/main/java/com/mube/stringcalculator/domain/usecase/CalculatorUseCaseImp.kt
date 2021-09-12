package com.mube.stringcalculator.domain.usecase

import com.mube.stringcalculator.utils.extensions.clearNewLines
import com.mube.stringcalculator.utils.extensions.getDelimiter
import com.mube.stringcalculator.utils.extensions.toIntOrZero

private const val DEFAULT_DELIMITER = ","
private const val DELIMITER_CONTROL_SYMBOL = "//"

class CalculatorUseCaseImp : CalculatorUseCase {

    override fun add(inputValue: String): Int {
        var sum = 0

        if (inputValue.isNotBlank()) {
            val delimiter = inputValue
                .getDelimiter(DELIMITER_CONTROL_SYMBOL, DEFAULT_DELIMITER)

            val numbers = inputValue
                .clearNewLines()
                .split(delimiter)

            numbers.forEach { number ->
                sum += number.trim().toIntOrZero()
            }
        }

        return sum
    }
}