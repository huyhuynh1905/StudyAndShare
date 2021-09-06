package packagejava.factorypattern;

/**
 * @project: factory-pattern
 * @author: HuyHuynh on 06/09/2021
 */
public interface PizzaIngredientFactory {
    AbsDough createDough();
    AbsSauce createSauce();
}
