package basics

fun main() {
    // val is used create mutable variables (constants)
    val name: String = "Surya"
    println("Name is $name and length of name is ${name.length}")
    // name = "Something else" // gives compilation error as we can't change the value of name

    // var is used create mutable variables
    var age: Int = 28
    println("Age is $age")
    // change the age value
    age = 29
    println("Changed age is $age") // No Compilation error, we can change the values of age

    // Multiline string
    var multiLine = """
        Line 1
        Line 2
        Line 3
    """.trimIndent()
    println(multiLine)
}