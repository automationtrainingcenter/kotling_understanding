package learnprogramming.basics

fun main() {
    val dummy = Dummy("Surya", 101)
    println(dummy)

    val change = 4.22 // print the change value as $4.22
    println("Change value in \$ is $$change")

    // we can put the expression inside the string template using {expression}
    val denominator = 2.50
    val numerator  = 20.00
    println("The value of $numerator devided by $denominator is ${numerator / denominator}")

    // raw strings or multi line strings
    val rStr = """This is a multiline string
        |which contains multiple lines of data
        |we can use string templates also in multiline string or raw strings
        |name of dummy is ${dummy.name} and id is ${dummy.id}
    """.trimMargin()

    println(rStr)
}

class Dummy(var name: String, val id: Int) {
    override fun toString(): String {
        return "Dummy(name=$name, id=$id)"
    }
}