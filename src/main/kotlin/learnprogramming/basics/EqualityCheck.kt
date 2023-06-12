package learnprogramming.basics

class Student(val name: String, val age: Int) {

    override fun equals(other: Any?): Boolean {
        if (other is Student) {
            return this.name == other.name && this.age == other.age
        }
        return false
    }
}

fun main() {
    val student1 = Student("Mary", 16)
    val student2 = Student("John", 16)
    val student3 = Student("John", 16)

    // structural equality which is similar to equals() of Java
    println(student1 == student2) // false
    println(student2 == student3) // true - both student2 and student3 have same structure and data

    // Referential equality which is equal to == operator in Java
    println(student1 === student2) // false
    println(student2 === student3) // false

    val student4 = student1
    println(student1 === student4) // true
    println(student1 == student4) // true
}