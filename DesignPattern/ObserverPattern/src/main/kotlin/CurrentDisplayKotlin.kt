/**
 * @project: observer-pattern
 * @author: HuyHuynh on 12/06/2021
 */
class CurrentDisplayKotlin(var subject: SubjectWeather) : ObserverWeather,DisplayData{
    var tempure: Float = 0F
    var humidity: Float = 0F
    var pressure: Float = 0F

    init {
        this.subject.registerObserver(this)
    }


    override fun update(tempure: Float, humidity: Float, pressure: Float) {
        this.tempure = tempure
        this.humidity = humidity
        this.pressure = pressure
        display()
    }

    override fun display() {
        println("CurrentDisplay: Temp = $tempure - Humidity = $humidity - Pressure = $pressure")
    }
}