package io.stupacki.pattern.creational

/*
 * Lazy Initialization
 *
 * Lazy Initialization is a programming technique that defers the creation
 * of an object or the calculation of a value until the first time it's needed.
 * This can potentially save resources if the object or value is never used
 * during the execution of the program, or if it is not needed until a long
 * time after program startup.  In Kotlin, you can use the lazy delegate to
 * implement lazy initialization for properties. The lazy delegate takes a
 * lambda and returns an instance of Lazy<T>, which can serve as a delegate
 * for implementing a lazy property: the first call to get() executes the
 * lambda passed to lazy() and remembers the result, subsequent calls to get()
 * simply return the remembered result.  In your project, the
 * LazyInitializationActivity class uses lazy initialization for the greenColor
 * property. This means that the value for greenColor ("Green") is not calculated
 * until the property is accessed for the first time, in the onCreated method.
 * This can be useful if the calculation of the property's value is expensive
 * (in terms of time or resources), and the value is not needed right away when
 * the object is created.
 *
 */

class LazyInitializationActivity {

    private val greenColor: String by lazy {
        println("Initializing green color")
        "Green"
    }

    private lateinit var redColor: String

    init {
        println("Initializing LazyInitializationActivity")
    }

    fun onCreated() {
        redColor = "Red"
        println(greenColor)
        println(redColor)
    }
}