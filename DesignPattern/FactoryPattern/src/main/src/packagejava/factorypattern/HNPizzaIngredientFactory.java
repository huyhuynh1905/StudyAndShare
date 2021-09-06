package packagejava.factorypattern;

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 06/09/2021
 */
public class HNPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public AbsDough createDough() {
        return new ThinCrusDough();
    }

    @Override
    public AbsSauce createSauce() {
        return new BrusSauce();
    }
}
