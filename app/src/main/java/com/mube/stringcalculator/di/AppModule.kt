package com.mube.stringcalculator.di

import com.mube.stringcalculator.domain.usecase.CalculatorUseCase
import com.mube.stringcalculator.domain.usecase.CalculatorUseCaseImp
import com.mube.stringcalculator.presentation.ui.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {

    private val useCase = module {
        factory<CalculatorUseCase> {
            CalculatorUseCaseImp(resources = androidContext().resources)
        }
    }

    private val viewModel = module {
        viewModel {
            MainViewModel(useCase = get())
        }
    }

    val all = listOf(useCase, viewModel)

}