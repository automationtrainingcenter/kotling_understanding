package basics

import java.time.LocalDate

fun sayHello(name: String) {
    println("Hello $name")
}

fun add(x: Int, y: Int) : Int {
    return x + y
}

fun addExp(x: Int, y: Int) = x + y // function expression

// function default values to parameters
fun getPersonDetails(name: String, email: String = "info@dummy.com", dob: LocalDate = LocalDate.now()) : String{
    return "Name: $name, email: $email and dob: $dob"
}

fun main() {
    sayHello("Surya")
    val sum = add(1, 2)
    println(sum)
    println(addExp(1, 2))
    println(getPersonDetails("Surya", "surya@dummy.com", LocalDate.parse("1987-03-01")))
    println(getPersonDetails("Teja"))
    println(getPersonDetails("Juno", "juno@dummy.com"))
    println(getPersonDetails("Theertha", dob = LocalDate.parse("2021-10-09"))) // Named arguments
}


