package com.mube.stringcalculator.presentation.ui.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.mube.stringcalculator.domain.model.Error
import com.mube.stringcalculator.domain.model.InputResult
import com.mube.stringcalculator.domain.model.Success
import com.mube.stringcalculator.domain.usecase.CalculatorUseCase

class MainViewModel(private val useCase: CalculatorUseCase) : ViewModel() {

    val input = MutableLiveData("")

    private val _result = MutableLiveData("")
    val result: LiveData<String>
        get() = _result

    private val _errorMsg = MutableLiveData("")
    val errorMsg: LiveData<String>
        get() = _errorMsg

    val errorVisibility: LiveData<Int>? = Transformations.map(_errorMsg) {
        if (it.isNotBlank()) View.VISIBLE else View.VISIBLE
    }

    private fun handleResult(result: InputResult) {
        when (result) {
            is Success -> {
                _result.value = result.value.toString()
                _errorMsg.value = ""
            }
            is Error -> {
                _errorMsg.value = result.message
                _result.value = ""
            }
        }
    }

    fun calculate() {
        val result = useCase.add(input.value.orEmpty())

        handleResult(result)
    }

    fun clear() {
        input.value = ""
        _result.value = ""
        _errorMsg.value = ""
    }
}