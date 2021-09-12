package com.mube.stringcalculator.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mube.stringcalculator.domain.usecase.CalculatorUseCase

class MainViewModel(private val useCase: CalculatorUseCase) : ViewModel() {

    val input = MutableLiveData("")

    private val _result = MutableLiveData("")
    val result: LiveData<String>
        get() = _result

    fun calculate() {
        _result.value = useCase.add(input.value.orEmpty()).toString()
    }

    fun clear() {
        input.value = ""
        _result.value = ""
    }
}