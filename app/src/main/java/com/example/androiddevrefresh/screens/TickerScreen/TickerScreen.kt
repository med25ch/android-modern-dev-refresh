package com.example.androiddevrefresh.screens.TickerScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevrefresh.data.NumbersRepository


@Composable
fun MyScreen(
    modifier: Modifier = Modifier
) {

    val repository = remember { NumbersRepository() }

    val viewModel: TickerScreenViewModel = viewModel(
        factory = TickerScreenViewModelFactory(repository)
    )

    // Collect the value from the ViewModel
    val text = viewModel.uiState.collectAsState()

    // Center the text in the screen
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "${text.value}",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
    }
}