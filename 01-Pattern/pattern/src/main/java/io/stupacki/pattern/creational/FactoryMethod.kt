package io.stupacki.pattern.creational

import io.stupacki.pattern.creational.Country.Canada
import io.stupacki.pattern.creational.Country.Greece
import io.stupacki.pattern.creational.Country.Spain
import io.stupacki.pattern.creational.Country.USA

/* Factory Method
 *
 * Define an interface for creating a single object, but let subclasses decide which class to instantiate. Factory Method lets a class defer
 * instantiation to subclasses.
 *
 * The Factory Method pattern is a creational design pattern that provides an interface for creating objects in a superclass, but allows
 * subclasses to alter the type of objects that will be created.  This pattern is used when a class cannot anticipate the type of objects it
 * needs to create, and it wants its subclasses to specify the objects it creates. It's also useful when a class delegates responsibilities
 * to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is the delegate.  In essence, the
 * Factory Method pattern is used to:
 *
 * - Decouple the creation of objects from the class that needs the objects.
 * - Allow a system to be independent of how its objects are created, composed, and represented.
 * - Promote loose coupling and scalability.
 * P- rovide hooks for subclasses to extend an object's construction process.
 *
 * The CurrencyFactory class is a good example of the Factory Method pattern. It creates a Currency object based on the Country object
 * passed to it. This way, the creation of Currency objects is decoupled from the main application and can be modified independently if the
 * need arises.
 * 
 */

// Implementation
sealed interface Country {
    data object USA : Country
    data object Spain : Country
    data class Greece(val someProperty: String) : Country
    data class Canada(val someProperty: String) : Country
}

class Currency(
    val code: String
)

object CurrencyFactory {

    fun currencyForCountry(country: Country): Currency =
        when (country) {
            is Greece -> Currency("EUR")
            is Spain -> Currency("EUR")
            is USA -> Currency("USD")
            is Canada -> Currency("CAD")
        }
}

// Usage
private fun main() {
    val country = Greece("Some property")
    val currency = CurrencyFactory.currencyForCountry(country)
    println(currency.code)
}