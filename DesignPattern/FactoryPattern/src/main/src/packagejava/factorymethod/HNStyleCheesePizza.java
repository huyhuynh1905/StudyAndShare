package packagejava.factorymethod;

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 24/07/2021
 */
public class HNStyleCheesePizza extends Pizza {
    public HNStyleCheesePizza() {
        name = "HNStyleCheesePizza";
        dough = "Thin";
        sauce = "Many";

        toping.add("Topping cheese fomat HN");
    }
}
