/**
 * @project: decorator-pattern
 * @author: HuyHuynh on 17/06/2021
 */
public class DrinkShopMain {
    public static void main(String[] args) {
        DrinkComponent coffee = new Coffee();
        DrinkComponent coffee1 = new SugarTopping(coffee);
        DrinkComponent coffee2 = new MochaTopping(coffee1);
        System.out.println("Your Order: "+coffee2.getDescription()+" - with cost: "+coffee2.cost()+"$");

        DrinkComponent milkTea = new MilkTea();
        DrinkComponent milktea1 = new MilkTopping(milkTea);
        DrinkComponent milktea2 = new MochaTopping(milktea1);
        DrinkComponent milktea3 = new MochaTopping(milktea2);
        System.out.println("Your Order: "+milktea3.getDescription()+" - with cost: "+milktea3.cost()+"$");
    }
}
