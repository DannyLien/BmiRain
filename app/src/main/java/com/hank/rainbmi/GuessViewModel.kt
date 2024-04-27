package com.hank.rainbmi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuessViewModel : ViewModel() {
    //LiveData
    val counter = MutableLiveData<Int>()
    var secret = (1..10).random()
    val secretData = MutableLiveData<Int>()
    val status = MutableLiveData<GameStatus>()

    init {
        counter.value = 0
        status.value = GameStatus.INIT
        secretData.value = secret
    }

    fun guess(num: Int) {
        status.value = when (num - secret) {
            in 1..Int.MAX_VALUE -> GameStatus.SMALLER
            0 -> GameStatus.NUMBER_RIGHT
            else -> GameStatus.BIGGER
        }
        var c = counter.value ?: 0
        c++
        counter.value = c

    }

    fun reset() {
        secret = (1..10).random()
        counter.value = 0
        status.value = GameStatus.INIT
        secretData.value = secret

    }

}

enum class GameStatus {
    INIT, BIGGER, SMALLER, NUMBER_RIGHT

}

