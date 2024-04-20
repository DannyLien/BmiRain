package com.hank.rainbmi.vending

import android.media.session.MediaSession.Token
import java.io.File

fun main() {
    var drinks = mutableListOf<Drink>()
    val input = File("order.txt").bufferedReader()
    var line = input.readLine()

    while (line != null) {
        println(line)
        val tokens = line.split(",")
        val drink = Drink(
            tokens[0], tokens[1].toInt(), tokens[2].toInt()
        )
        drinks.add(drink)
        line = input.readLine()
    }
    println(drinks)

}










