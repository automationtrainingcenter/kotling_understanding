package basics

/*
public is the default access modifiers
private is accessible with in the class
protected is accessible with in the sub class
Internal (Kotlin only) private to the module that's published using Gradle and Maven
 */

open class AccessModifiersDemo {
    fun publicFunction() {
        println("public function")
    }

    private fun privateFun() {
        println("private function")
    }

    protected open fun protectedFun() {
        println("protected function")
    }
}

class AccessModifiersDemo2 {

    fun accessFuns() {
        val obj = AccessModifiersDemo()
        obj.publicFunction()
//        obj.privateFunction() // private function is not accessible
//        obj.potectedFun() // protected function is only accessible in sub class
    }
}

class AccessModifiersDemo3 : AccessModifiersDemo() {
    public override fun protectedFun() {
        super.protectedFun()
    }
}

fun main() {
    val obj = AccessModifiersDemo3()
    obj.publicFunction()
    obj.protectedFun()
}
