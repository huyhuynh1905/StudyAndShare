package factorymethod;

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 24/07/2021
 */
public class HNStyleClamPizza extends Pizza {
    public HNStyleClamPizza(){
        name = "HNStyleClamPizza";
        dough = "Litte";
        sauce = "Many";

        toping.add("Topping Clam HN");
    }
}
