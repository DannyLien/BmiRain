package com.hank.rainbmi
import kotlin.random.Random

class GuessGame {
    var secret: Int = Random.nextInt(1, 11)
    var counter = 0
    fun guess(n: Int): Int {
        counter++
        return secret - n
    }

    fun reset() {
        secret = Random.nextInt(1, 11)
        counter = 0
    }

}


fun main() {
    var game = GuessGame()
    var playStatus = 1

    while (playStatus == 1) {
        println("game.secret is : ${game.secret}")
        var message = 0
        var result = ""
        var bingo = false
        while (game.counter < 3) {
            print("Please enter number 1-10 : ")
            val input = readLine()
            var num: Int = input?.toIntOrNull() ?: 0
            println("The number you enter : $num")
            message = game.guess(num)
            result = when {
                message > 0 -> "Bigger"
                message < 0 -> "Smaller"
                else -> "You got it!"
            }
            println(result)
            if (message == 0) {
                bingo = true
                break
            }
        }
        if (!bingo) {
            println("Game Failed, Secret Number is : ${game.secret}")
        }
        println("Do your want play again ?? ")
        print("Enter 1 = Yes , other = No : ")
        val input = readLine()
        playStatus = input?.toIntOrNull() ?: 0
        if (playStatus==1) {
            game.reset()
        }else{
            println("End Game , Bye")
        }

    }

}