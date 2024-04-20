package com.hank.rainbmi.vending

fun main() {

    val tea = Drink("Black tea", 0, 50)
    println(tea)
    val tea2 = tea.copy(suger = 5)
    println(tea2)

    //method-2
    val drinks = mutableMapOf<Int, String>(
        //method-1
//    val drinks = mapOf<Int, String>(
        1 to "Coke",
        2 to "7-up",
        3 to "Wuloong",
        4 to "Orange",
    )
    println(drinks)
    println(drinks.get(3))
    drinks.put(5, "Water")
    println(drinks)
}