/**
 * @project: decorator-pattern
 * @author: HuyHuynh on 18/06/2021
 */
class SeaweedSoup(foodComponent: FoodComponent) : FoodDecorator() {
    var foodComponent: FoodComponent = foodComponent

    override var description: String?
        get() = "${foodComponent.description?:""}, add Seaweed Soup"
        set(value) {}
    override fun cost(): Double {
        return foodComponent.cost() + 12000
    }
}