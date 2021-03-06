package com.mube.stringcalculator.domain.usecase

import android.content.res.Resources
import org.junit.Before
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import com.mube.stringcalculator.domain.model.Success
import io.mockk.mockkClass

class CalculatorUseCaseImpTest {

    private lateinit var sut: CalculatorUseCase

    @Before
    fun setup() {
        sut = CalculatorUseCaseImp(mockkClass(Resources::class))
    }

    @Test
    fun successWithEmptyValue() {
        val result = sut.add(inputValue = "")
        val expected = Success(0)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun withOneValue() {
        val result = sut.add(inputValue = "5")
        val expected = Success(5)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun withMultiplesValues() {
        val result = sut.add(inputValue = "1,2,5")
        val expected = Success(8)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun withWrongSeparated() {
        val result = sut.add(inputValue = "1%2,5,2")
        val expected = Success(7)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun withDifferentSeparated() {
        val result = sut.add(inputValue = "//%\n1%2%5%2")
        val expected = Success(10)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun withMultiplesDifferentSeparated() {
        val result = sut.add(inputValue = "//%,$\n1%2%5$2")
        val expected = Success(10)

        assertThat(result).isEqualTo(expected)
    }

}