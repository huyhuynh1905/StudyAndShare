package factorymethod;

import java.util.ArrayList;

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 24/07/2021
 */
abstract public class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList<String> toping = new ArrayList();

    void prepare(){
        System.out.println("Prepare pizza with name: "+name);
        System.out.println("... Dough");
        System.out.println("... Sauce");
        for (int i =0;i<toping.size();i++){
            System.out.println("    ... "+toping.get(i));
        }
    }

    void bake(){
        System.out.println("Bake the pizza");
    }

    void cut(){
        System.out.println("Cutting the pizza");
    }

    void box(){
        System.out.println("Box the pizza");
    }

    public String getName() {
        return name;
    }
}
