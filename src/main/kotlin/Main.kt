import kotlin.reflect.KClass
import kotlin.reflect.full.allSuperclasses

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")
    println(getIntegratableClass(AI::class))
    task3()
}

private fun err(clazz: KClass<*>) {
    println("$clazz or parents is not annotated with Integratable")
}

private fun getIntegratableClass(target: KClass<*>): KClass<out Any>? {
    //Check if itself integratable
    if (isIntegratable(target)) return target
    //Or find integratable parent class
    return target.allSuperclasses
        .firstOrNull(::isIntegratable)
        .also { if (it == null) err(target) }
}

private fun isIntegratable(target: KClass<*>) =
    target.annotations.any { it.annotationClass == AN::class }

annotation class AN

@AN
interface A1

class AI : A1