package com.mube.stringcalculator.utils.extensions

fun String.toIntOrZero(): Int = this.toIntOrNull()?.run {
    val number = toInt()

    if (number > 1000) 0 else number
}.orZero()

fun String.clearNewLines(): String = replace("\n", "")

fun String.removeText(text: String): String = replace(text, "")

fun String.getDelimiter(delimiterSymbol: String, default: String): List<String> {
    val listDelimiter = mutableListOf(default)

    if (startsWith(delimiterSymbol)) {
        val delimiterLine = this.firstLine().removeText(delimiterSymbol).trim()
        val newDelimiterList = delimiterLine.split(",")

        if (newDelimiterList.isNotEmpty()) {
            listDelimiter.clear()
            listDelimiter.addAll(newDelimiterList)
        }

    }

    return listDelimiter.toList()
}

fun String.firstLine(): String = split("\n").first()

fun String.isChar(): Boolean = (this.toIntOrZero() == 0)

fun String.clearWhiteSpaces(): String = replace("\\s".toRegex(), "")

fun String.clearDelimiter(delimiter: String): String = replace(delimiter, "")

fun String.isNegativeNumber(): Boolean = this.startsWith("-")

fun List<String>.toSingleString() = if (this.size == 1) this.first() else joinToString(", ")