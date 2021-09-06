package packagekotlin.factorymethod

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 24/07/2021
 */
class HNStyleCheesePizzaKt : Pizzakt() {
    init {
        name = "HNStyleCheesePizza"
        dough = "Thin"
        sauce = "Many"
        toping.add("Topping cheese fomat HN")
    }
}