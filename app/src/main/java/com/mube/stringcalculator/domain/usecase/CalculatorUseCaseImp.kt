package com.mube.stringcalculator.domain.usecase

import android.content.res.Resources
import com.mube.stringcalculator.R
import com.mube.stringcalculator.domain.model.Error
import com.mube.stringcalculator.domain.model.InputResult
import com.mube.stringcalculator.domain.model.Success
import com.mube.stringcalculator.utils.extensions.*

private const val DEFAULT_DELIMITER = ","
private const val DELIMITER_CONTROL_SYMBOL = "//"
private const val FORBIDDEN_DELIMITER = "-"

class CalculatorUseCaseImp(private val resources: Resources) : CalculatorUseCase {

    override fun add(inputValue: String): InputResult {
        var sum = 0
        val negatives: MutableList<String> = mutableListOf()

        if (inputValue.isNotBlank()) {
            val delimiter = inputValue
                .getDelimiter(DELIMITER_CONTROL_SYMBOL, DEFAULT_DELIMITER)

            if (delimiter.isForbiddenDelimiter()) {
                return Error(resources.getString(R.string.error_delimiter))
            }

            val numbers = inputValue
                .clearDelimiter(DELIMITER_CONTROL_SYMBOL + delimiter)
                .clearNewLines()
                .split(delimiter)

            numbers.forEach { number ->
                if (number.isNegativeNumber()) {
                    negatives.add(number)
                } else {
                    sum += number.trim().toIntOrZero()
                }
            }
        }

        return if (negatives.isEmpty()) {
            Success(sum)
        } else {
            Error(resources.getString(R.string.error_negative, negatives.toSingleString()))
        }
    }
}

private fun String.isForbiddenDelimiter(): Boolean = (this == FORBIDDEN_DELIMITER)