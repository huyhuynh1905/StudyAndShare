package packagejava.factorymethod;

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 24/07/2021
 */
public class TestMain {
    public static void main(String[] args) {
        PizzaStore hnS = new HNPizzaStore();
        PizzaStore sgS = new SGPizzaStore();

        Pizza pzhnCheese = hnS.orderPizza("cheese");
        System.out.println();
        System.out.println("==================================");
        Pizza pzsgClam = sgS.orderPizza("clam");
    }
}
