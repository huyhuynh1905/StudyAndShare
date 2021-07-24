package factorymethod

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 24/07/2021
 */
abstract class PizzaStoreKt {
    fun orderPizza(nameOfPizza: String?): Pizzakt? {
        var pizza: Pizzakt? = createPizza(nameOfPizza)
        pizza?.prepare()
        pizza?.bake()
        pizza?.cut()
        pizza?.box()
        return pizza
    }

    protected abstract fun createPizza(nameOfPizza: String?): Pizzakt?
}
