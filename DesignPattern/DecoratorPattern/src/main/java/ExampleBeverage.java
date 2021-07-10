/**
 * @project: decorator-pattern
 * @author: HuyHuynh on 10/07/2021
 */
public class ExampleBeverage {
    public String description;
    public boolean milk;
    public boolean soy;
    public boolean mocha;
    public boolean whip;

    public void setDescription(String description) {
        this.description = description;
    }
    public void setMilk(boolean milk) {
        this.milk = milk;
    }
    public void setSoy(boolean soy) {
        this.soy = soy;
    }
    public void setMocha(boolean mocha) {
        this.mocha = mocha;
    }
    public void setWhip(boolean whip) {
        this.whip = whip;
    }

    public String getDescription() {
        return description;
    }

    public boolean isMilk() {
        return milk;
    }

    public boolean isSoy() {
        return soy;
    }

    public boolean isMocha() {
        return mocha;
    }

    public boolean isWhip() {
        return whip;
    }

    public Double cost(){
        Double cost = Double.valueOf(0);
        if (isMilk()){
            cost += 10; //Giá của topping milk
        }
        if (isMocha()){
            cost +=5;
        }
        if (isSoy()){
            cost += 8;
        }
        if (isWhip()){
            cost += 15;
        }
        return cost;
    }
}
