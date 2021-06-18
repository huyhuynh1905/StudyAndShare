/**
 * @project: decorator-pattern
 * @author: HuyHuynh on 18/06/2021
 */
class RiceNoodle: FoodComponent() {
    init {
        super.description = "Rice Noodle"
    }

    override fun cost(): Double {
        return 30000.0
    }
}