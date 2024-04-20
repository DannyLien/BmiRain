package com.hank.rainbmi

fun main() {
    //Set
    val set = setOf<Int>(5, 3, 9, 3, 2, 1, 9)
    println(set)
    set.forEach { num ->
        //method-2
        println(num)
        //method-1
        //println(it)
    }
    //Listof
    val list = listOf<Int>(5, 3, 8, 5, 3, 2, 1)
    println(list)
    //mutableList
    //C,D,H,S
    val deck = mutableListOf<Int>()
    for (i in 0 until 52) {//0..<52
        deck.add(i)
        if (i % 13 == 0 && i != 0) println()
        val a = i / 13
        //method-3
        var type = when (a) {
            0 -> "♣"
            1 -> "♢"
            2 -> "♡"
            else -> "♠"
        }
        //method-2
//        var type = if (a == 0) {
//            "C"
//        } else if (a == 1) {
//            "D"
//        } else if (a == 2) {
//            "H"
//        } else {
//            "S"
//        }
        //method-1
//        var type = "S"
//        if (a == 0) {
//            type = "C"
//        } else if (a == 1) {
//            type = "D"
//        } else if (a == 2) {
//            type = "H"
//        }
        print("${(i % 13) + 1}$type ")
    }
    println()
    println(deck)
    val deck2 = deck.shuffled()
    println(deck)
    println(deck2)
    val a = deck.shuffled().first()
    val b = deck.shuffled().first()

}