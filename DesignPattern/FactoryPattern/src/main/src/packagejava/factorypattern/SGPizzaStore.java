package packagejava.factorypattern;

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 07/09/2021
 */
public class SGPizzaStore extends AbsPizzaStore {
    @Override
    protected AbsPizza createPizza(String nameOfPizza) {
        AbsPizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new SGPizzaIngredientFactory();
        if (nameOfPizza.equals("Cheese")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("SG Cheese Pizza");
        }
        if (nameOfPizza.equals("Clam")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("SG Clam Pizza");
        }

        return pizza;
    }
}
