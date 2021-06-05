package javadesignpattern;

/**
 * @project: strategypattern
 * @author: HuyHuynh on 05/06/2021
 */
public class MuteQuack implements IQuackBehaviors {
    @Override
    public void quack() {
        System.out.println("...............!");
    }
}
