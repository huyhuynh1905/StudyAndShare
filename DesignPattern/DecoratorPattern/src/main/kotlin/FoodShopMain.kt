/**
 * @project: decorator-pattern
 * @author: HuyHuynh on 18/06/2021
 */

fun main() {
    val rice = BrokenRice()
    val rice1 = LemonsSalt(rice)
    val rice2 = SeaweedSoup(rice1)
    println("Rice: ${rice2.description} - with cost: ${rice2.cost()}")

    val noodle = RiceNoodle()
    val noodle1 = LemonsSalt(noodle)
    val noodle2 = LemonsSalt(noodle1)
    println("Noodle: ${noodle2.description} - with cost: ${noodle2.cost()}")
}