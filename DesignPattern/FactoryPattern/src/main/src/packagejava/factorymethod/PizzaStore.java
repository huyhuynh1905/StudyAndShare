package packagejava.factorymethod;

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 24/07/2021
 */
abstract public class PizzaStore {

    Pizza orderPizza(String nameOfPizza){
        Pizza pizza;
        pizza = createPizza(nameOfPizza);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(String nameOfPizza);
}
