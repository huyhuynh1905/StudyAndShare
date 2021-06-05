package kotlindesignpattern

/**
 * @project: strategypattern
 * @author: HuyHuynh on 05/06/2021
 */
class FlyWithWings : IFlyBehaviors {
    override fun fly() {
        println("Flyyy with wings!!!")
    }
}