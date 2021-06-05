package javadesignpattern;

/**
 * @project: strategypattern
 * @author: HuyHuynh on 05/06/2021
 */
public class VitCaoSu extends Vit {

    public VitCaoSu() {
        flyBehaviors = new NoFly();
        quackBehaviors = new MuteQuack();
    }

    @Override
    void display() {
        System.out.println("Vịt cao su");
    }
}
