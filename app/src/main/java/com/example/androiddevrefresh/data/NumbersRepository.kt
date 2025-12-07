package com.example.androiddevrefresh.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.math.BigInteger

class NumbersRepository : INumbersRepository {
    override suspend fun getNumbers(): Flow<Int> = flow {
        for (i in 1..1000) {
            emit(i)
            delay(2000)
        }
    }.flowOn(Dispatchers.Default)
}