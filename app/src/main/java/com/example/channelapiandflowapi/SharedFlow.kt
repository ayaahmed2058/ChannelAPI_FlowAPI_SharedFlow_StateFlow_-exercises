package com.example.channelapiandflowapi

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch


suspend fun main(): Unit =  coroutineScope {

    val sharedFlow  = MutableSharedFlow<Int>(replay = 1 , onBufferOverflow = BufferOverflow.SUSPEND)

    launch {
        sharedFlow.collect {
            println("first: $it")
        }
    }

    launch {
        sharedFlow.collect {
            println("second: $it")
        }
    }

    sharedFlow.emit(5)
    sharedFlow.emit(3)
    sharedFlow.emit(9)
    sharedFlow.emit(8)

    launch {
        sharedFlow.collect {
            println("third: $it")
        }
    }


}