package packagekotlin.factorypattern

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 07/09/2021
 */
abstract class AbsPizzaKt {
    var name: String? = null
    var dough: AbsDoughKt? = null
    var sauce: AbsSauceKt? = null


    abstract fun prepare()

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