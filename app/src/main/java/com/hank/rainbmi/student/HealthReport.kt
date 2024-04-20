package com.hank.rainbmi.student

class HealthReport:Report {
    override fun load() {
        println("Loading Health")
    }

    override fun print(title: String) {
        println("Printing Health")
    }
}