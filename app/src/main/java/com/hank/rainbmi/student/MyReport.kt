package com.hank.rainbmi.student

//抽象類別, 方法沒大括號, 要加 abstract 敘述
abstract class MyReport {

    abstract fun load()

    fun print(){
        println("Printing..")
    }

    fun init(){
        //加了大括號, 不能當抽象方法
    }

}