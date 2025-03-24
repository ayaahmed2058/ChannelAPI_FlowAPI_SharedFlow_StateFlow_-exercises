package com.example.channelapiandflowapi

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main ():Unit = runBlocking{

    val channel = Channel<String> ()
    val listOfFruits = listOf("Apple" , "Orange" , "Banana" , "Pear")


    //Producer - Sender
    GlobalScope.launch {
        for(fruit in listOfFruits) {
            channel.send(fruit)
            if(fruit == "Banana")
                channel.close()
        }

    }

    //Receiver - Consume
    for(fruitReceived in channel)
        println(fruitReceived)





//    getFruits().consumeEach {
//        println(it)
//    }

}

fun getFruits() = GlobalScope.produce<String> {
    val listOfFruits = listOf("Apple" , "Orange" , "Banana" , "Pear")
    for(fruit in listOfFruits) {
        channel.send(fruit)
        if(fruit == "Orange")
            channel.close()
    }
}