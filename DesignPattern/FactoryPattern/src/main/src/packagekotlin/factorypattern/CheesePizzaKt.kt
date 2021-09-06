package packagekotlin.factorypattern

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 07/09/2021
 */
class CheesePizzaKt : AbsPizzaKt {
    var ingredientFactoryKt: PizzaIngredientFactoryKt? = null
    constructor(ingredientFactoryKt: PizzaIngredientFactoryKt) : super(){
        this.ingredientFactoryKt = ingredientFactoryKt
    }
    override fun prepare() {
        println("Prepaing... $name !")
        dough = ingredientFactoryKt?.createDough()
        sauce = ingredientFactoryKt?.createSauce()
    }
}