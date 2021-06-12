/**
 * @project: observer-pattern
 * @author: HuyHuynh on 12/06/2021
 */
interface ObserverWeather {
    fun update(tempure: Float, humidity: Float, pressure: Float)
}