/**
 * @project: decorator-pattern
 * @author: HuyHuynh on 18/06/2021
 */
class LemonsSalt(foodComponent: FoodComponent) : FoodDecorator() {
    var foodComponent: FoodComponent = foodComponent

    override var description: String?
        get() = "${foodComponent.description}, add LemonSalt"
        set(value) {}

    override fun cost(): Double {
        return foodComponent.cost()+ 3000
    }


}