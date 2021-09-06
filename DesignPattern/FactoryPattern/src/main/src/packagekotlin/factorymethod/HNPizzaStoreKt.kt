package packagekotlin.factorymethod

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 24/07/2021
 */
class HNPizzaStoreKt : PizzaStoreKt() {
    override fun createPizza(nameOfPizza: String?): Pizzakt? {
        return when (nameOfPizza) {
            "cheese" -> HNStyleCheesePizzaKt()
            "clam" -> HNStyleClamPizzaKt()
            else -> null
        }
    }
}