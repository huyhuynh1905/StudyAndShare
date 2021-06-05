package kotlindesignpattern

/**
 * @project: strategypattern
 * @author: HuyHuynh on 05/06/2021
 */
class QuackQuack : IQuackBehaviors {
    override fun quack() {
        println("Quack quack!!!")
    }
}