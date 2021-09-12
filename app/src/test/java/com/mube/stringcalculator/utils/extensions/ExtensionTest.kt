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
    fun clearNewLinesExtension() {
        val result = "1\n23\n45".clearNewLines()
        val expected = "12345"

        assertThat(result).isEqualTo(expected)
    }

}