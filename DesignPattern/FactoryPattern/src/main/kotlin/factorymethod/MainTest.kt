package factorymethod

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 24/07/2021
 */

fun main() {
    val hnS: PizzaStoreKt = HNPizzaStoreKt()
    val pzhnCheese: Pizzakt? = hnS.orderPizza("cheese")
    println()
}