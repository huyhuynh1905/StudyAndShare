package packagejava.factorypattern;


/**
 * @project: factory-pattern
 * @author: HuyHuynh on 07/09/2021
 */
public class CheesePizza extends AbsPizza {
    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing "+name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
    }
}
