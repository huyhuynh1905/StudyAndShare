/**
 * @project: decorator-pattern
 * @author: HuyHuynh on 18/06/2021
 */
class BrokenRice: FoodComponent() {
    init {
        description = "BrokenRice"
    }
    override fun cost(): Double {
        return 35000.0
    }
}