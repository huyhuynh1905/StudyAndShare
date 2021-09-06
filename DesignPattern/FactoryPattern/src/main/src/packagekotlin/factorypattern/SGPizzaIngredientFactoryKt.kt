package packagekotlin.factorypattern

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 07/09/2021
 */
class SGPizzaIngredientFactoryKt : PizzaIngredientFactoryKt {
    override fun createDough(): AbsDoughKt {
        return ThinCrusDoughKt()
    }

    override fun createSauce(): AbsSauceKt {
        return TomatoSauceKt()
    }
}