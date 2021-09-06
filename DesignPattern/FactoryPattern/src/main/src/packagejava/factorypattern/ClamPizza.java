package packagejava.factorypattern;

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 07/09/2021
 */
public class ClamPizza extends AbsPizza {

    PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Preparing "+name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
    }
}
