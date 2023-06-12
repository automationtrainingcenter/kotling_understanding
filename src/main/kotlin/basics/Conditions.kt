package basics

fun main() {
    val num = 8
    // simple if
    if (num > 0) {
        println("num is positive")
    }

    // if else
    if (num % 2 == 0)  {
        println("num is even")
    } else {
        println("num is odd")
    }

    // else if ladder
    val rank = if (num >= 8) {
        "Destinction"
    } else if (num >= 7) {
        "First class"
    } else if (num >= 6) {
        "Second class"
    } else {
        "Fail"
    }

    // when condition
    val browserName = "something"

    val browser = when (browserName) {
        "chrome" -> "ChromeDriver"
        "firefox" -> "FirefoxDriver"
        "edge" -> "EdgeDriver"
        else -> "IEDriver"
    }

    println("Browser driver is $browser")


}