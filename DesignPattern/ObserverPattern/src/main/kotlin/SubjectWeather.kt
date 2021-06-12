/**
 * @project: observer-pattern
 * @author: HuyHuynh on 12/06/2021
 */
interface SubjectWeather {
    fun registerObserver(observerWeather: ObserverWeather)
    fun remove(observerWeather: ObserverWeather)
    fun noityfyData()
}