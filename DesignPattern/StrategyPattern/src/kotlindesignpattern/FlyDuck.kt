package kotlindesignpattern

import kotlindesignpattern.Duck as Duck

/**
 * @project: strategypattern
 * @author: HuyHuynh on 05/06/2021
 */
class FlyDuck : Duck {
    constructor(){
        flyBehaviors = FlyWithWings()
        quackBehaviors = QuackQuack()
    }
    override fun display() {
        println("Vịt trời")
    }
}