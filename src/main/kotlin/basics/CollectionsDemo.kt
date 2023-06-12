package basics

import datasets.Course
import datasets.CourseCategory
import datasets.KAFKA
import datasets.courseList

fun lists() {
    // immutable list
    val iList = listOf("Java", "Python", "Kotlin", "Dart", "Javascript")
    println("immutable lis is $iList")

    // mutable list
    val mList = mutableListOf("Spring", "Micronaut", "Quarkus", "Django", "Flask", "Nodejs")
    println("mutable list is $mList")

    mList.add("React")
    println("mutable list after adding a value is $mList")

    println("mList contains Quarkus ${"Quarkus" in mList}")
    println("item at index 0 is ${mList[0]}")

    // for loop for list
    for (item in iList) {
        print("${item.uppercase()}  ")
    }
    println()
    println("Total number of items in mutable list is ${mList.size}")
}

fun maps() {
    // immutable map
    val iMap = mapOf(1 to "React", 2 to "Vue", 3 to "Angular", 4 to "React Native", 5 to "Flutter")
    println("immutable map is $iMap")

    val mMap =
        mutableMapOf(101 to "MongoDB", 102 to "Postgresql", 103 to "Oracle", 104 to "My SQL", 105 to "MS SQL Server")
    println("mutable map is $mMap")

    // adding a new value to map
    mMap[106] = "Express"
    println("mutable map after new value $mMap")

    // get the number of items in a map
    println("Total number of items in mutable map is ${mMap.size} and total number of items in immutable map is ${iMap.size}")

    // check an item in map or not
    println("Express is in immutable map : ${106 in iMap}")
    println("Express is in mutable map : ${106 in mMap}")

    // get keys of the map
    println("Keys of mutable map are ${mMap.keys}")
    println("Values of mutable map are ${mMap.values}")
    println("Items of mutable map are ${mMap.entries}")

    // for loop on map
    for (item in mMap) {
        println(item)
    }
}

fun sets() {
    // immutable set
    val iSet = setOf("Selenium", "UFT", "Cypress", "Playwright", "WebdriverIO", "Selenium")
    println("immutable set is $iSet")


    // mutable set
    val mSet = mutableSetOf("IntelliJ", "Pycharm", "Eclipse", "Netbeans", "VScode", "Xcode")
    println("mutable set is $mSet")

    // add an item to set
    mSet.add("Sublime text")
    println("mutable set after adding a new value is $mSet")

    // get total number of items in a set
    println("Total number of items in a set ${mSet.size}")

    // for loop on set
    for (item in mSet) {
        println(item)
    }
}

// lambda functions
fun lambdas() {
    // lambda functions
    val add = { x: Int -> x + x }
    val mul = { x: Int, y: Int -> x * y }
    val pow = { x: Int, y: Int ->
        println("calculating the power of given number $x and $y")
        Math.pow(x.toDouble(), y.toDouble()).toInt()
    }
    println(add(2))
    println(mul(2, 3))
    println(pow(2, 3))
}


// higher order functions
fun highOrderFun(x: Int, y: Int, op: (x: Int, y: Int) -> Int): Int {
    return op(x, y)
}

// filter function
fun exploreFilter(courses: MutableList<Course>) {
    // prints development courses everytime
    courses.filter { it.category == CourseCategory.DEVELOPEMENT }.forEach { println(it) }
}

fun exploreDynamicFilter(courses: MutableList<Course>, predicate: (Course) -> Boolean) {
    // prints courses based on the predicate passed
    courses.filter(predicate).forEach { println(it) }
}

// map function
fun exploreMap(courses: MutableList<Course>) {
    courses.map { Course(100 + it.id, it.name, it.category, it.topicsCovered) }.forEach { println(it) }
}

// flat map function
fun exploreFlatMap(courses: MutableList<Course>, KAFKA: String): List<String> {
    return courses.flatMap { crs ->
        val courseName = crs.name
        crs.topicsCovered.filter {
            it == KAFKA
        }.map {
            courseName
        }
    }
}

fun main() {

    lists()
    maps()
    sets()
    lambdas()
    println(highOrderFun(2, 3) { a: Int, b: Int -> a + b })
    println(highOrderFun(3, 4) { a, b -> a * b })
    val courses = courseList()
    exploreFilter(courses)
    exploreDynamicFilter(courses) { c: Course -> c.category == CourseCategory.DEVELOPEMENT }
    val designPredicate = { c: Course -> c.category == CourseCategory.DESIGN }
    exploreDynamicFilter(courses, designPredicate)

    exploreMap(courses)
    val kafkaCourses = exploreFlatMap(courses, KAFKA)
    println(kafkaCourses)
}