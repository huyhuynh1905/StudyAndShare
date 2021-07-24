package factorymethod;

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 24/07/2021
 */
public class SGStyleClamPizza extends Pizza {
    public SGStyleClamPizza(){
        name = "SGStyleClamPizza";
        dough = "Litte dough";
        sauce = "Litte sauce";
        toping.add("Topping clam SG");
    }
}
