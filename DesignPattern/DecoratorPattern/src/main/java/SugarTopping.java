/**
 * @project: decorator-pattern
 * @author: HuyHuynh on 17/06/2021
 */
public class SugarTopping extends DrinkDecorator {
    DrinkComponent drinkComponent;

    public SugarTopping(DrinkComponent drinkComponent) {
        this.drinkComponent = drinkComponent;
    }

    @Override
    double cost() {
        return drinkComponent.cost() + 5000;
    }

    @Override
    public String getDescription() {
        return drinkComponent.getDescription() + ", add Sugar";
    }
}
