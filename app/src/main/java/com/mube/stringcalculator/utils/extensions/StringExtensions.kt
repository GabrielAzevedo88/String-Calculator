package com.mube.stringcalculator.utils.extensions

fun String.toIntOrZero(): Int = this.toIntOrNull()?.run {
    toInt()
}.orZero()

fun String.clearNewLines(): String = replace("\n", "")