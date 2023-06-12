package basics

class LoopsAndRanges {
}

fun exploreFor() {
    var range = 1..10
    for (i in range) {
        println("i = $i")
    }

    var reverseRange = 10 downTo 1
    for (i in reverseRange step 2) {
        print("i = $i\t")
    }

    var name = "Surya Prakash"
    for (each in name.reversed()) {
        print(each)
    }
}

fun exploreWhile() {
    var i = 1
    while (i < 5) {
        println(i)
        i++
    }
}

fun exploreDoWhile() {
    var i = 0
    do {
        print("$i ")
        i++
    } while (i <= 5)

}

fun exploreBreak() {
    for (i in 1..5) {
        println("i = $i")
        for (j in 1..5) {
            println("    j = $j")
            if (j == 2) {
                break
            }
        }
    }
}

fun exploreLabel() {
    outer@ for (i in 1..5) {
        println("i = $i")
        inner@ for (j in 1..5) {
            println("    j = $j")
            if (j == 2) {
                break@outer
            }
        }
    }
}

fun main() {
//    exploreWhile()
//    exploreDoWhile()
    exploreBreak()
    println("*******************************************")
    exploreLabel()
}