package com.hank.rainbmi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuessViewModel : ViewModel() {
    val counter = MutableLiveData<Int>()

    init {
        counter.value = 0
    }

    fun guess(num: Int) {
        var c = counter.value ?: 0
        c++
        counter.value = c
    }
}