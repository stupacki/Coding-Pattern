package io.stupacki.pattern.creational

/*
 * Builder Pattern
 *
 * Separate the construction of a complex object from its representation, allowing the same construction process to create various representations.
 *
 * The Builder Pattern is used when there is a need to construct complex objects step by step. It separates the construction of an object from its
 * representation, allowing the same construction process to create various representations. This pattern is particularly useful when the
 * construction process of an object is complex and should be independent of the parts that make up the object and how they're assembled.  In the
 * context of your project, the Builder Pattern is used in the BuilderPattern.kt file to create House objects. The House.HouseBuilder interface
 * acts as the builder, and the House.HouseBuilderImpl class is the concrete builder. The House class is the product. The buildHouse function
 * demonstrates how to use the builder to create a House object.
 */

// Implementation
data class House(var windows: Int = 0, var doors: Int = 0) {

    interface HouseBuilder {
        fun setWindows(count: Int): HouseBuilder
        fun setDoors(count: Int): HouseBuilder
        fun build(): House
    }

    class HouseBuilderImpl : HouseBuilder {
        private var house: House = House()

        override fun setWindows(count: Int): HouseBuilder {
            house.windows = count
            return this
        }

        override fun setDoors(count: Int): HouseBuilder {
            house.doors = count
            return this
        }

        override fun build(): House {
            return house
        }
    }
}

//Usage
private fun buildHouse(): House {
    val houseBuilder = House.HouseBuilderImpl()
    val house = houseBuilder
        .setWindows(4)
        .setDoors(2)
        .build()
    return house
}
