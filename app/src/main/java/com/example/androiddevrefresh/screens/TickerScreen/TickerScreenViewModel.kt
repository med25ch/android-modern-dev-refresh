package com.example.androiddevrefresh.screens.TickerScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevrefresh.data.INumbersRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TickerScreenViewModel(
    private val numbersRepository: INumbersRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(0)
    val uiState : StateFlow<Int> = _uiState

    init {
        viewModelScope.launch {
            numbersRepository.getNumbers().collect {
                _uiState.value = it
            }
        }
    }
}