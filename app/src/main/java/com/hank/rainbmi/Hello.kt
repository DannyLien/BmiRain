package com.hank.rainbmi

class Hello {

}

fun main() {
    val p = Person()
    p.hello()           //Hello

    println("Hello Kotlin")    //Hello Kotlin

    //Byte, Short, Int, Long
    val age = 20
    val population = 9999L
    println(age.inc())  //21
    println(age)        //20
    var name = "Hank"
    println(name.get(1))//a
    name = "Jack"
    println(name)       //Jack
    //Float(32), Double(64)
    val weight: Float = 65.5f
    //true, false
    val isAdult = false
    //Char
    val c = 'A'
    println(c)          //A
}