package com.example.androiddevrefresh.screens.TickerScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
    val tickerUiState = viewModel.uiState.collectAsState()

    Box (modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // ✅ Main Text from ViewModel
            Text(
                text = "${tickerUiState.value.counterValue}",
                style = MaterialTheme.typography.headlineMedium,
            )

            // ✅ Click Counter Text
            Text(
                text = "Clicks: ${tickerUiState.value.clicksCounter}",
                style = MaterialTheme.typography.bodyLarge
            )

            // ✅ Button
            Button(
                onClick = {
                    viewModel.incrementCounter()
                }
            ) {
                Text("Click Me")
            }
        }
    }
}