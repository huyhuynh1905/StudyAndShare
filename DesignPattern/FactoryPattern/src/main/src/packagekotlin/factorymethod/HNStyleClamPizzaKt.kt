package packagekotlin.factorymethod

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 24/07/2021
 */
class HNStyleClamPizzaKt : Pizzakt() {
    init {
        name = "HNStyleClamPizza"
        dough = "Litte"
        sauce = "Many"
        toping.add("Topping Clam HN")
    }
}