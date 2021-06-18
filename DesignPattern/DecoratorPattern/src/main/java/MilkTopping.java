/**
 * @project: decorator-pattern
 * @author: HuyHuynh on 17/06/2021
 */
public class MilkTopping extends DrinkDecorator {
    DrinkComponent drinkComponent;

    public MilkTopping(DrinkComponent drinkComponent) {
        this.drinkComponent = drinkComponent;
    }

    @Override
    double cost() {
        return drinkComponent.cost() + 10000;
    }

    @Override
    public String getDescription() {
        return drinkComponent.getDescription() + ", add Milk";
    }
}
