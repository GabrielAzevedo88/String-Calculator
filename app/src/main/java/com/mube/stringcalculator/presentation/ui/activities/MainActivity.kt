package com.mube.stringcalculator.presentation.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mube.stringcalculator.R
import com.mube.stringcalculator.databinding.ActivityMainBinding
import com.mube.stringcalculator.presentation.ui.viewmodel.MainViewModel
import com.mube.stringcalculator.utils.extensions.bindingContentView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
    }

    private fun setupBinding() {
        bindingContentView<ActivityMainBinding>(R.layout.activity_main).run {
            viewModel = this@MainActivity.viewModel
            lifecycleOwner = this@MainActivity
        }
    }
}