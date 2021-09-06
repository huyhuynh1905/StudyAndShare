package packagejava.factorypattern;

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 06/09/2021
 */
public abstract class AbsPizza {
    String name;
    AbsDough dough;
    AbsSauce sauce;

    abstract void prepare();

    void bake(){
        System.out.println("Bake the pizza");
    }

    void cut(){
        System.out.println("Cutting the pizza");
    }

    void box(){
        System.out.println("Box the pizza");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
