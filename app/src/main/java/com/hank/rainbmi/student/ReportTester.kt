package com.hank.rainbmi.student

fun main() {

    val reports = listOf<Report>(
        FinaceReport(),
        HealthReport(),
    )

    for (report in reports){
        report.load()
        report.print("Test")
    }

}