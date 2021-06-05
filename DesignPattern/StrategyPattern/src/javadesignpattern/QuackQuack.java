package javadesignpattern;

/**
 * @project: strategypattern
 * @author: HuyHuynh on 05/06/2021
 */
public class QuackQuack implements IQuackBehaviors {
    @Override
    public void quack() {
        System.out.println("Quackkk Quackk!!");
    }
}
