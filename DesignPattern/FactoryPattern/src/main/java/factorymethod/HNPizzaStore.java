package factorymethod;

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 24/07/2021
 */
public class HNPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String nameOfPizza) {
        Pizza pizza;
        switch (nameOfPizza){
            case "cheese":
                pizza = new HNStyleCheesePizza();
                break;
            case "clam":
                pizza = new HNStyleClamPizza();
                break;
            default:
                pizza = null;
        }
        return pizza;
    }
}
