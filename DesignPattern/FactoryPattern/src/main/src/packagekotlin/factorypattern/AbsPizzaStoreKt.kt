package packagekotlin.factorypattern

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 07/09/2021
 */
abstract class AbsPizzaStoreKt {
    fun orderPizza(nameOfPizza: String) : AbsPizzaKt? {
        var pizza: AbsPizzaKt? = createPizza(nameOfPizza)
        pizza?.prepare()
        pizza?.bake()
        pizza?.cut()
        pizza?.box()
        return pizza
    }


    protected abstract fun createPizza(nameOfPizza: String?):AbsPizzaKt?
}