package com.example.androiddevrefresh.screens.TickerScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androiddevrefresh.data.INumbersRepository

class TickerScreenViewModelFactory(private val numbersRepository: INumbersRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TickerScreenViewModel(numbersRepository) as T
    }
}