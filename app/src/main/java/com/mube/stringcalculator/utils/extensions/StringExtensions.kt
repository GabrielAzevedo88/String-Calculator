package com.mube.stringcalculator.utils.extensions

fun String.toIntOrZero(): Int = this.toIntOrNull()?.run {
    toInt()
}.orZero()

fun String.clearNewLines(): String = replace("\n", "")

fun String.removeText(text: String): String = replace(text, "")

fun String.getDelimiter(delimiterSymbol: String, default: String): String {
    var delimiter = default

    if (startsWith(delimiterSymbol)) {
        val newDelimiter = this.firstLine().removeText(delimiterSymbol).trim()

        if (newDelimiter.isNotBlank() && newDelimiter.isChar()) delimiter = newDelimiter
    }

    return delimiter
}

fun String.firstLine(): String = split("\n").first()

fun String.isChar(): Boolean = (this.toIntOrZero() == 0)