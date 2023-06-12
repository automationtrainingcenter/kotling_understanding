package basics


// data class used to create POJO classes or beans equivalent in Java
data class Course(
    val id: Int,
    val name: String,
    val author: String,
    val courseCategory: CourseCategory = CourseCategory.DEVELOPMENT
)

enum class CourseCategory {
    DEVELOPMENT,
    TESTING,
    MARKETING,
    DEVOPS
}


// interface
interface CourseRepository {

    // abstract method
    fun findByID(id: Int): Course

    // concrete method
    fun save(course: Course): Int {
        println("$course is saved")
        return course.id
    }

}

// another interface
interface Repository {
    fun getAll(): Any
}

// course
class SQLCourseRepository : CourseRepository, Repository {
    override fun findByID(id: Int): Course {
        return Course(1, "Spring boot with Kotlin", "Surya")
    }

    override fun getAll(): Any {
        return 1
    }
}


// another class implementing interfaces and overriding the default or concrete method of interfaces
class NoSQLRepository : CourseRepository, Repository {
    override fun findByID(id: Int): Course {
        return Course(101, "MongoDB", "Teja")
    }

    override fun getAll(): Any {
        return 101
    }

    // overriding default method of CourseRepository interface
    override fun save(course: Course): Int {
        println("NoSQL course saved $course")
        return course.id
    }

}


fun main() {
    val courseRepo = SQLCourseRepository()
    var course = courseRepo.findByID(1)
    println("Course is $course")
    println("Number of records are ${courseRepo.getAll()}")

    var cid = courseRepo.save(Course(2, "Spring boot with Java", "Surya"))
    println("Course id is $cid")
    course = courseRepo.findByID(2)
    println("Course is $course")

    val noSqlRepo = NoSQLRepository()
    println(noSqlRepo.findByID(101))
    cid = noSqlRepo.save(Course(102, "MySQL", "Teja"))
    println("Course id is $cid")
    course = noSqlRepo.findByID(102)
    println("Course is $course")
}