package packagekotlin.factorypattern

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 07/09/2021
 */
interface PizzaIngredientFactoryKt {
    fun createDough() : AbsDoughKt
    fun createSauce() : AbsSauceKt
}