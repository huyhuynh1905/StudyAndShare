package kotlindesignpattern

/**
 * @project: strategypattern
 * @author: HuyHuynh on 05/06/2021
 */
abstract class Duck {
    open lateinit var flyBehaviors: IFlyBehaviors
    open lateinit var quackBehaviors: IQuackBehaviors
    constructor()
    fun formFly(){
        flyBehaviors.fly()
    }
    fun formQuack(){
        quackBehaviors.quack()
    }
    abstract fun display()
}