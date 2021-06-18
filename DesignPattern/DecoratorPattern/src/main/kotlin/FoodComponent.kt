/**
 * @project: decorator-pattern
 * @author: HuyHuynh on 18/06/2021
 */
abstract class FoodComponent {
    open var description: String?= null
    abstract fun cost() : Double
}