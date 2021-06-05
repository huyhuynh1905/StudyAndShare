package javadesignpattern;

/**
 * @project: strategypattern
 * @author: HuyHuynh on 05/06/2021
 */
public abstract class Vit {
    IFlyBehaviors flyBehaviors;
    IQuackBehaviors quackBehaviors;

    public void formFly(){
        flyBehaviors.fly();
    }

    public void formQuack(){
        quackBehaviors.quack();
    }

    abstract void display();
}
