package packagejava.factorypattern;


/**
 * @project: factory-pattern
 * @author: HuyHuynh on 07/09/2021
 */
public class MainFactoryJv {
    public static void main(String[] args) {
        AbsPizzaStore hnS = new HNPizzaStore();
        AbsPizzaStore sgS = new SGPizzaStore();

        AbsPizza cheese = hnS.orderPizza("Cheese");
        AbsPizza clam = hnS.orderPizza("Clam");
    }
}
