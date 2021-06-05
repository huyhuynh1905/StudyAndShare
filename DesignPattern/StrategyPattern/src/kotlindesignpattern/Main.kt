package kotlindesignpattern

/**
 * @project: strategypattern
 * @author: HuyHuynh on 05/06/2021
 */

fun main(){
    val flyDuck = FlyDuck()
    flyDuck.display()
    flyDuck.formFly()
    flyDuck.formQuack()
}