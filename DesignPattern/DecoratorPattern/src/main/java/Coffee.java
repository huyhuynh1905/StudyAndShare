/**
 * @project: decorator-pattern
 * @author: HuyHuynh on 17/06/2021
 */
public class Coffee extends DrinkComponent {

    public Coffee() {
        description = "This is Coffee";
    }

    @Override
    double cost() {
        return 18000;
    }
}
