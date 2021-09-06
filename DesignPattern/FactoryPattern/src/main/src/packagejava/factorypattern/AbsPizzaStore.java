package packagejava.factorypattern;


/**
 * @project: factory-pattern
 * @author: HuyHuynh on 07/09/2021
 */
public abstract class AbsPizzaStore {

    AbsPizza orderPizza(String nameOfPizza){
        AbsPizza pizza;
        pizza = createPizza(nameOfPizza);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract AbsPizza createPizza(String nameOfPizza);
}
