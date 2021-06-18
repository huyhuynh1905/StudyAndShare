/**
 * @project: decorator-pattern
 * @author: HuyHuynh on 17/06/2021
 */
public class MilkTea extends DrinkComponent {

    public MilkTea() {
        description = "This is MilkTea";
    }

    @Override
    double cost() {
        return 30000;
    }
}
