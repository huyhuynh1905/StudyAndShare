package javadesignpattern;

/**
 * @project: strategypattern
 * @author: HuyHuynh on 05/06/2021
 */
public class FlyWithWings implements IFlyBehaviors {
    @Override
    public void fly() {
        System.out.println("I'm Flyyy by wings");
    }
}
