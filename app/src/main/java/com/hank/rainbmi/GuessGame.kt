package com.hank.rainbmi

import kotlin.random.Random

class GuessGame {
    enum class Status {
        INIT, SMALLER, BIGGER, BINGO
    }

    var secret: Int = Random.nextInt(1, 11)
    var counter = 0
    var status = Status.INIT

    fun guess(n: Int): Status {
        counter++
        return if (n > secret) Status.SMALLER
        else if (n < secret) Status.BIGGER
        else Status.BINGO
    }

    fun reset() {
        secret = Random.nextInt(1, 11)
        counter = 0
    }

}

/*
fun main() {
    var game = GuessGame()
    var playStatus = 1

    while (playStatus == 1) {
        println("game.secret is : ${game.secret}")
        var message = 0
//        var result = ""
        var bingo = false
        var min = 1
        var max = 10
        while (game.counter < 3) {
//            print("Please enter number 1-10 : ")
            print("Please enter a number ($min-$max) : ")
            val input = readLine()
            var num: Int = input?.toIntOrNull() ?: 0
//            println("The number you enter : $num")
//            message = game.guess(num)
//            result = when {
//                message > 0 -> "Bigger"
//                message < 0 -> "Smaller"
//                else -> "You got it!"
//            }
//            println(result)
            message = game.guess(num)   //secret - n
            when {
                message > 0 -> min = num    //Bigger
                message < 0 -> max = num    //Smaller
                else -> {       //bingo
                    if (message == 0) {
                        bingo = true
                        break
                    }
                }
            }
        }
        if (!bingo) {
            println("Game Failed, Secret Number is : ${game.secret}")
        } else {
            println("You got it!")
        }
        println("Do your want play again ?? ")
        print("Enter 1 = Yes , other = No : ")
        val input = readLine()
        playStatus = input?.toIntOrNull() ?: 0
        if (playStatus == 1) {
            game.reset()
        } else {
            println("End Game , Bye")
        }

    }

}
*/