package javadesignpattern;

/**
 * @project: strategypattern
 * @author: HuyHuynh on 05/06/2021
 */
public class NoFly implements IFlyBehaviors {
    @Override
    public void fly() {
        System.out.println("I'm Not Fly!!!");
    }
}
