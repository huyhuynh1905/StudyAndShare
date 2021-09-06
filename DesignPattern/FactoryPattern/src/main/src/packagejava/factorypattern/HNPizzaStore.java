package packagejava.factorypattern;


/**
 * @project: factory-pattern
 * @author: HuyHuynh on 07/09/2021
 */
public class HNPizzaStore extends AbsPizzaStore {
    @Override
    protected AbsPizza createPizza(String nameOfPizza) {
        AbsPizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new HNPizzaIngredientFactory();
        if (nameOfPizza.equals("Cheese")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("HN Cheese Pizza");
        }
        if (nameOfPizza.equals("Clam")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("HN Clam Pizza");
        }

        return pizza;
    }
}
