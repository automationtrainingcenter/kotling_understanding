package learnprogramming.basics
typealias EmployeeList = MutableList<Employee>


class Employee(var name: String, var designation: String, var salary: Double) {
    fun getDetails() {
        println("Employee name is $name, designation is $designation and salary is $salary")
    }
}

fun main() {
    val emps: EmployeeList = mutableListOf(Employee("Surya", "Lead", 50000.00), Employee("Prakash", "Tester", 65000.00))
    for (emp in emps) {
        emp.getDetails()
    }
}