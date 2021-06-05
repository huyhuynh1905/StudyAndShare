package kotlindesignpattern

/**
 * @project: strategypattern
 * @author: HuyHuynh on 05/06/2021
 */
class MuteQuack : IQuackBehaviors {
    override fun quack() {
        println("............!")
    }
}