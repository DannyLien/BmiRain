package com.hank.rainbmi.student
//
//學生有學號,姓名,英文,數學,成績
//印出學生資料
//印出學生平均成績
//印出學生等級(A,B,C,D)

class Student(
    val id: String,
    val name: String,
    var english: Int = 0,
    var math: Int = 0
) {
    //    constructor(id: String, name: String) : this(id, name, 0, 0)
    companion object {
        var pass = 60
    }

    val mark = if (average() < pass) "*" else " "

    fun print() {
        println("$id\t$name\t$english\t$math\t${average()}$mark\t${grading()}")
    }

    fun average(): Int {
        return (english + math) / 2
    }

    fun grading() = when (average() / 10) {
        9, 10 -> "A"
        8 -> "B"
        7 -> "C"
        6 -> "D"
        else -> "F"
    }

}


fun main() {
    Student.pass = 50
    val students = listOf<Student>(
        Student("001", "Jack", 40, 60),
        Student("002", "Hank", 66, 87),
        Student("003", "Jane")
    )
    //meehod-3
    for (stu in students) {
        stu.print()
    }
    //method-2
//    for (i in 0..2){
//        students.get(i).print()
//    }
    //method-1
//    val stu1 = Student("001", "Jack", 100, 100)
//    val stu2 = Student("002", "Hank", 66, 87)
//    val stu3 = Student("003", "Jane")
//    stu1.print()
//    stu2.print()
//    stu3.print()

}













