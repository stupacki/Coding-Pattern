package io.stupacki.pattern.creational

/*
 * Dependency Injection
 *
 * A class accepts the objects it requires from an injector instead of creating the objects directly.
 *
 *
 */

// Implementation

// Component
interface DiComponentInterface {
    val modules: List<DiModule>
    fun <T : Any> inject(target: Class<T>): T
}

//Module
interface DiModuleInterface<T : Any> {
    var targets: Map<Class<*>, T>
    fun addTarget(value: Any)
}

class DiModule : DiModuleInterface<Any> {
    override var targets: Map<Class<*>, Any> = emptyMap()

    override fun addTarget(value: Any) {
        targets += value::class.java to value
    }
}

@Suppress("UNCHECKED_CAST")
class DiComponent(
    override val modules: List<DiModule> = emptyList(),
) : DiComponentInterface {

    override fun <T : Any> inject(target: Class<T>): T {
        modules.forEach { module ->
            module.targets.forEach { moduleTarget ->
                if (moduleTarget.key == target) {
                    return moduleTarget.value as T
                }
            }
        }
        throw IllegalArgumentException("Target not found")
    }
}

// Usage

// Component
fun mainComponent(): DiComponent = DiComponent(
    modules = listOf(mainModule())
)

// Module
fun mainModule(): DiModule = DiModule().apply {
    addTarget(MainViewModel())
}


class MainViewModel {
    val state: List<String> = listOf("INITIAL_STATE")
}

object TargetView {

    private val module: DiComponent = mainComponent()
    private val mainViewModel: MainViewModel = module.inject(MainViewModel::class.java)

    init {
        mainViewModel.state.forEach { state ->
            println(state)
        }
    }
}
