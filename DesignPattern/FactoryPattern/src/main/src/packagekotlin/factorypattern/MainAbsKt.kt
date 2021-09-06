package packagekotlin.factorypattern


/**
 * @project: factory-pattern
 * @author: HuyHuynh on 07/09/2021
 */

fun main() {
    val sgS: AbsPizzaStoreKt = SGPizzaStoreKt()
    val pzhnCheese: AbsPizzaKt? = sgS.orderPizza("Clam")
    println()
}