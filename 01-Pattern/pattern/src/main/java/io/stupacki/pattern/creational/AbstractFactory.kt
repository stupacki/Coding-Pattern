package io.stupacki.pattern.creational

/*
 * Abstract Factory Pattern
 * Provide an interface for creating families of related or dependent objects without specifying their concrete classes.
 *
 * The Abstract Factory Pattern is used in situations where a system should be independent from how its products are created,
 * composed, and represented. It is typically applied when:
 * - A system should be configured with one of multiple families of products.
 * - These products are designed to be used together, and it's important that a system uses products from only one family at
 *   a time.
 * - The system provides an interface for creating a family of related objects, without specifying their concrete classes.
 * - In the context of your project, the Abstract Factory Pattern is used in the AbstractFactoryPattern.kt file to create
 *   different types of Vehicle objects (like Car and Bike). The VehicleFactory class acts as the abstract factory, and the
 *   CarFactory and BikeFactory classes are the concrete factories. The Vehicle interface is the abstract product, and Car
 *   and Bike are the concrete products. The buildCar and buildBike functions demonstrate how to use the factories to create
 *   vehicles.
 */

// Implementation
interface Vehicle

class Car : Vehicle

class Bike : Vehicle

abstract class VehicleFactory {

    abstract fun makeVehicle(): Vehicle

    companion object {
        inline fun <reified T : Vehicle> createFactory(): VehicleFactory = when (T::class) {
            Car::class -> CarFactory()
            Bike::class -> BikeFactory()
            else -> throw IllegalArgumentException()
        }
    }
}

class CarFactory : VehicleFactory() {
    override fun makeVehicle(): Vehicle = Car()
}

class BikeFactory : VehicleFactory() {
    override fun makeVehicle(): Vehicle = Bike()
}

// Usage
private fun buildCar(): Vehicle {
    val carFactory = VehicleFactory.createFactory<Car>()
    val car = carFactory.makeVehicle()
    return car
}

private fun buildBike(): Vehicle {
    val bikeFactory = VehicleFactory.createFactory<Bike>()
    val bike = bikeFactory.makeVehicle()
    return bike
}