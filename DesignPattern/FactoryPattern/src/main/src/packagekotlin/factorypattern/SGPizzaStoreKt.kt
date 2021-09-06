package packagekotlin.factorypattern


/**
 * @project: factory-pattern
 * @author: HuyHuynh on 07/09/2021
 */
class SGPizzaStoreKt : AbsPizzaStoreKt() {
    override fun createPizza(nameOfPizza: String?): AbsPizzaKt? {
        var pizza: AbsPizzaKt? = null;
        var ingredientFactoryKt: PizzaIngredientFactoryKt = SGPizzaIngredientFactoryKt()
        if (nameOfPizza == "Cheese") {
            pizza = CheesePizzaKt(ingredientFactoryKt)
            pizza.name = "SG Cheese Pizza"
        }
        if (nameOfPizza == "Clam") {
            pizza = ClamPizzaKt(ingredientFactoryKt)
            pizza.name = "SG Clam Pizza"
        }
        return pizza
    }
}