package factorymethod

import java.util.*

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 24/07/2021
 */
abstract class Pizzakt {
    var name: String? = null
    var dough: String? = null
    var sauce: String? = null
    var toping: MutableList<String?> = mutableListOf()
    fun prepare() {
        println("Prepare pizza with name: $name")
        println("... Dough")
        println("... Sauce")
        for (i in toping.indices) {
            println("    ... " + toping[i])
        }
    }

    fun bake() {
        println("Bake the pizza")
    }

    fun cut() {
        println("Cutting the pizza")
    }

    fun box() {
        println("Box the pizza")
    }
}
