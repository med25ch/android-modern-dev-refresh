package com.example.androiddevrefresh.data


import kotlinx.coroutines.flow.Flow

interface INumbersRepository {
    suspend fun getNumbers(): Flow<Int>
}

