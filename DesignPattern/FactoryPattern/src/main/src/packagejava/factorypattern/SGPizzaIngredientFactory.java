package packagejava.factorypattern;

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 06/09/2021
 */
public class SGPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public AbsDough createDough() {
        return new ThickCrusDough();
    }

    @Override
    public AbsSauce createSauce() {
        return new TomatoSauce();
    }
}
