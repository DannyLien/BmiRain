package com.hank.rainbmi.vending

import java.io.File

fun main() {
    val drinks = listOf<Drink>(
        Drink("Black tea", 0, 50),
        Drink("Green tea", 5, 45),
        Drink("Wuloon tea", 0, 60),

        )
    var out = File("order.txt").printWriter().buffered()
    for (d in drinks) {
        //buffered()
        out.write("${d.name},${d.suger},${d.price}\n")
        //none buffered()
//        out.println("${d.name},${d.suger},${d.price}")
    }
    out.flush()

}