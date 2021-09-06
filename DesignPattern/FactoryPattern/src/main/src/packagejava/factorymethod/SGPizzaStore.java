package packagejava.factorymethod;

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 24/07/2021
 */
public class SGPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String nameOfPizza) {
        Pizza pizza;
        switch (nameOfPizza){
            case "cheese":
                pizza = new SGStyleCheesePizza();
                break;
            case "clam":
                pizza = new SGStyleClamPizza();
                break;
            default:
                pizza = null;
        }
        return pizza;
    }
}
