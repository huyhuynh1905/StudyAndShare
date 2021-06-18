/**
 * @project: decorator-pattern
 * @author: HuyHuynh on 17/06/2021
 */
public abstract class DrinkComponent {
    public String description;
    abstract double cost();
    public String getDescription(){
        return this.description;
    }
}
