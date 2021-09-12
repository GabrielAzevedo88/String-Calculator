package com.mube.stringcalculator.domain.usecase

import com.mube.stringcalculator.utils.orZero

private const val DELIMITER = ","

class CalculatorUseCaseImp : CalculatorUseCase {

    override fun add(inputValue: String): Int {
        var sum = 0

        if (inputValue.isNotBlank()) {
            val numbers = inputValue.split(DELIMITER)

            numbers.forEach { number ->
                sum += number.trim().filterValue()
            }
        }

        return sum
    }
}

private fun String.filterValue(): Int = this.toIntOrNull()?.run {
    toInt()
}.orZero()