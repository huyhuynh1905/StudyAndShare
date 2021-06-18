/**
 * @project: decorator-pattern
 * @author: HuyHuynh on 17/06/2021
 */
public class MochaTopping extends DrinkDecorator {

    DrinkComponent drinkComponent;

    public MochaTopping(DrinkComponent drinkComponent) {
        this.drinkComponent = drinkComponent;
    }

    @Override
    double cost() {
        return drinkComponent.cost() + 15000;
    }

    @Override
    public String getDescription() {
        return drinkComponent.getDescription() + ", add Mocha";
    }
}
