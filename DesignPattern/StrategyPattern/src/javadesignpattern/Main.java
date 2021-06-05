package javadesignpattern;

/**
 * @project: strategypattern
 * @author: HuyHuynh on 05/06/2021
 */
public class Main {
    public static void main(String[] args) {
        VitCaoSu vcs = new VitCaoSu();
        vcs.display();
        vcs.formFly();
        vcs.formQuack();
    }
}
