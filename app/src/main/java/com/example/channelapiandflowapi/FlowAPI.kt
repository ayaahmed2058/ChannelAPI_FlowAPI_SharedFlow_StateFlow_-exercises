package com.example.channelapiandflowapi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map


//Producer - sender - observable - cold stream
fun getNumbers () = flow<Int>{

    for(i in 1..10){
        delay(500)
        emit(i)
    }

}

suspend fun main() = coroutineScope{

    getNumbers()
        .filter { it > 5 }                //intermediate - non terminal operators
        //.flowOn(Dispatchers.IO)
        .map { it * 2 }
        .debounce(20)
        //.flowOn(Dispatchers.Default)
        .collect{                        //(suspend fun)
            println(it)
        }                                // consumer - receiver - observer
}