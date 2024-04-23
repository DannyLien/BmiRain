package com.hank.rainbmi.student

fun main() {

    val reports = listOf<Report>(
        FinaceReport(),
        HealthReport(),
        //匿名類別
        object : Report{
            override fun load() {
                println("Ex Report")
            }

            override fun print(title: String) {
                println("Ex Printing")
            }
        }
    )

    for (report in reports){
        report.load()
        report.print("Test")
    }

}