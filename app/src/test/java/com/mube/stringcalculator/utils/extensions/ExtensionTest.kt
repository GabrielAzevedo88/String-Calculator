package com.mube.stringcalculator.utils.extensions

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExtensionTest {

    @Test
    fun stringToIntSuccess() {
        val result = "20".toIntOrZero()
        val expected = 20

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun stringToIntError() {
        val result = "GG".toIntOrZero()
        val expected = 0

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun stringToLargeIntSuccess() {
        val result = "1001".toIntOrZero()
        val expected = 0

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun stringToLargeIntError() {
        val result = "1000".toIntOrZero()
        val expected = 1000

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun clearNewLinesExtension() {
        val result = "1\n23\n45".clearNewLines()
        val expected = "12345"

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun delimiterSuccess() {
        val result = "//$$\n1\n23\n45".getDelimiter("//", ",")
        val expected = listOf("$$")

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun delimiterNoSymbolError() {
        val result = "\n1\n23\n45".getDelimiter("//", ",")
        val expected = listOf(",")

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun delimiterNoValueError() {
        val result = "//\n1\n23\n45".getDelimiter("//", ",")
        val expected = listOf(",")

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun delimiterNumberError() {
        val result = "//1\n23\n45".getDelimiter("//", ",")
        val expected = listOf(",")

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun multipleDelimiterSuccess() {
        val result = "//$,%\n1\n23\n45".getDelimiter("//", ",")
        val expected = listOf("$", "%")

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun firsLineOnly() {
        val result = "1\n23\n45".firstLine()
        val expected = "1"

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun valueIsCharSuccess() {
        val result = "@@".isChar()
        val expected = true

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun valueIsCharError() {
        val result = "11".isChar()
        val expected = false

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun isNegativeSuccess() {
        val result = "-8".isNegativeNumber()
        val expected = true

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun isNegativeError() {
        val result = "8".isNegativeNumber()
        val expected = false

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun listToSingleString() {
        val result = listOf("1", "2", "3", "4", "5").toSingleString()
        val expected = "1, 2, 3, 4, 5"

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun listToSingleStringWithOneValue() {
        val result = listOf("1").toSingleString()
        val expected = "1"

        assertThat(result).isEqualTo(expected)
    }

}