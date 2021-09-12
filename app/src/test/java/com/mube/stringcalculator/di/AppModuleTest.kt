package com.mube.stringcalculator.di

import android.content.Context
import com.mube.stringcalculator.domain.usecase.CalculatorUseCase
import com.mube.stringcalculator.domain.usecase.CalculatorUseCaseImp
import io.mockk.mockkClass
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import com.google.common.truth.Truth.assertThat
import com.mube.stringcalculator.presentation.ui.viewmodel.MainViewModel

@RunWith(JUnit4::class)
class AppModuleTes : KoinTest {

    @Before
    fun setUp() {
        startKoin {
            androidContext(mockkClass(Context::class))
            modules(AppModule.all)
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun useCaseModulesTest() {
        val useCase: CalculatorUseCase by inject()

        assertThat(useCase).isInstanceOf(CalculatorUseCaseImp::class.java)
    }

    @Test
    fun viewModelModulesTest() {
        val viewModel: MainViewModel by inject()

        assertThat(viewModel).isNotNull()
    }

}