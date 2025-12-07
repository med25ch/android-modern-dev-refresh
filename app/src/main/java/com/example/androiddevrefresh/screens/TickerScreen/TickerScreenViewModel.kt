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

    private val _uiState = MutableStateFlow(TickerUiState())
    val uiState : StateFlow<TickerUiState> = _uiState

    init {
        viewModelScope.launch {
            numbersRepository.getNumbers().collect {
                _uiState.value = _uiState.value.copy(counterValue = it)
            }
        }
    }

    fun incrementCounter() {
        _uiState.value = _uiState.value.copy(clicksCounter = _uiState.value.clicksCounter + 1)
    }

}

data class TickerUiState(
    val counterValue: Int = 0,
    val clicksCounter: Int = 0,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)