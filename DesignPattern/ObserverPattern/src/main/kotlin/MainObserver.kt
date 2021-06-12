/**
 * @project: observer-pattern
 * @author: HuyHuynh on 12/06/2021
 */

fun main(){
    val dataCenterWeather = DataCenterWeather()
    val messageDisplay = MessageDisplay(dataCenterWeather)
    var currentDisplay = CurrentDisplayKotlin(dataCenterWeather)

    dataCenterWeather.measureDataChange(1F,2F,3F)
    dataCenterWeather.measureDataChange(4F,5F,6F)
    dataCenterWeather.remove(currentDisplay)
    dataCenterWeather.measureDataChange(7F,8F,9F)

}