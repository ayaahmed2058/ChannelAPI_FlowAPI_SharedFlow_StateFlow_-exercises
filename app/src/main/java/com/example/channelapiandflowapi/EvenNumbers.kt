package com.example.channelapiandflowapi

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.take


fun evenNumbers () = flow<Int>{

    //val evenNumbers = flowOf<Int>(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40)

    val evenNumbers = listOf(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40)

    for (i in evenNumbers){
        delay(1000)
        emit(i)
    }

}

suspend fun main() = coroutineScope{

    evenNumbers()
        .take(10)
        .collect{
            println(it)
        }

}