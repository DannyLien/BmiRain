package com.hank.rainbmi.vending

//Extension擴充功能
fun Drink.off20(): Drink {
    return this.copy(price = (this.price * 0.8).toInt())
}

fun main() {
    //Extension
    val s = "abcef"
    println(s.validate())
    val tea = Drink("Black tea", 0, 50)
    //Extension
    val discountTea = tea.off20()
    println(tea)
    println(discountTea)
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

//Extension 擴充功能
fun String.validate(): Boolean {
    return this.length >= 6
}

