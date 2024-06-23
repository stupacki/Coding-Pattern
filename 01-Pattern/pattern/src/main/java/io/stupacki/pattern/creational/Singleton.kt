package io.stupacki.pattern.creational

/*
 * Singleton
 *
 * A Singleton is used in the Singleton.kt file in your project. The Singleton
 * pattern ensures that a class has only one instance and provides a global
 * point of access to it. In Kotlin, this can be easily achieved using the
 * object declaration.
 *
 * Additional: Singletons in DI
 *
 */

object Singleton {
    init {
        println("Initializing Singleton")
    }

    fun doSomething() {
        println("Doing something")
    }
}