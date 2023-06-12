package learnprogramming.basics


fun main() {
    // creating a immutable variable
    val pi = 3.14
    // pi = 2 // throws compilation error
    val number: Short = 20 // variable declaration by providing hte data type
    val number2: Int = 30 // No need to provide the data type because Kotlin will infer the data type based on the value assigned
    // Variables declared using the val keyword can be assigned only once in a block
    val isAllowed: Boolean // declaration

    if (number > 20) {
        isAllowed = true // Assigning a value based on condition
    } else {
        isAllowed = false
    }




    // Creating a mutable variable
    var name = "surya"
    name = "prakash" // allows changes

    // we can't change the datatype of a variable
//    name = 10 // throws compile time error

    /*
    NOTE: Declaring variables using val is good practice
     */

}