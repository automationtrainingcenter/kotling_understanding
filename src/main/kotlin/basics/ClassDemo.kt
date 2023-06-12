package basics

// class wiht out any constructor
class Person {
    fun action() {
        println("Person walks")
    }
}

// class with primary constructor
class Employee(var name: String, var designation: String, var salary: Double) {
    fun getDetails() {
        println("Employee name is $name, designation is $designation and salary is $salary")
    }
}

// class with primary constructor with default values
class Student(val name: String, var course: String = "", var fee: Int = 0) {
    fun getDetails() {
        println("Student name is $name, course is $course and fee is $fee")
    }
}

// class with secondary constructor
class Vehicle(val name: String) {
    var model: String = ""
    var price: Int = 0

    constructor(_name: String, _model: String, _price: Int) : this(_name) {
        model = _model
        price = _price
    }

    fun getDetails() {
        println("Car name = $name, model = $model and price = $price")
    }
}

// class with init block: is used to develop initialize logic
class Product {
    init {
        println("Inside init block")
    }

    constructor(i: Int) {
        println("i = $i")
    }
}

// class with properties, getters and setters
class Item {
    var name: String = ""
    var price: Int = 0
        get() = field
        set(value) {
            field = value * 10
        }

    constructor(_name: String, _price: Int) {
        this.name = _name
        this.price = _price
    }
}


// inheritance
open class User(val name: String) {
    open var isLoggedIn: Boolean = false
    open fun login() {
        println("Hey $name, Inside User login")
    }
}

class Learner(name: String) : User(name) {
    override fun login() {
        super.login() // calling parent class login method
        this.isLoggedIn = true
    }

    fun rateCourse() {
        if (this.isLoggedIn) {
            println("Add your rating...")
        } else {
            println("Authentication required")
        }
    }
}

class Trainer(name: String) : User(name) {
    override var isLoggedIn: Boolean = true

    override fun login() {
        println("Hey $name, Inside Trainer login")
    }

    fun addContent() {
        println("loggedin... ${this.isLoggedIn}, Adding content")
    }
}

// object keyword which is similar to singleton pattern in java
object Authenticator {

    fun authenticate(userName: String, password: String) {
        println("User is authenticated, Welcome ${userName.uppercase()}")
    }
}

// companion object is used to achieve static methods and variables in classes
class Asset(var make: String, var model: String) {

    companion object {
        val company: String = "Conti"

        fun showWarning() {
            println("Asset Name should be unique")
        }
    }

    fun getDetails() {
        println("Asset Make is $make and model is $model")
    }
}

fun main() {
    val person = Person()
    person.action()

    val emp = Employee("Surya", "Lead", 5000.00)
    emp.getDetails()

    val s1 = Student("Jack")
    s1.getDetails()

    val s2 = Student(name = "Kate", fee = 1000) // named arguments
    s2.getDetails()

    val car = Vehicle("Honda", "civic", 500000)
    car.getDetails()

    val p = Product(10)

    val i1 = Item("iPhone", 8)
    println("Item name = ${i1.name} and price = ${i1.price}")
    i1.name = "iPhone 13"
    i1.price = 2
    println("Item name = ${i1.name} and price = ${i1.price}")


    val user = User("User") // parent class
    user.login()

    val learner = Learner("Learner") // child 1 class
    learner.login()
    learner.rateCourse()

    val trainer = Trainer("Trainer") // child 2 class
    trainer.login()
    trainer.addContent()


    Authenticator.authenticate("surya", "abc")

    // companion object: access static content
    println("Asset company is ${Asset.company}")
    Asset.showWarning()
    var asset = Asset("Tata", "Nano")
    asset.getDetails()

}