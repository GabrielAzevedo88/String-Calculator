package com.mube.stringcalculator.utils.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <T : ViewDataBinding> AppCompatActivity.bindingContentView(layout: Int): T =
    DataBindingUtil.setContentView(this, layout) as T
