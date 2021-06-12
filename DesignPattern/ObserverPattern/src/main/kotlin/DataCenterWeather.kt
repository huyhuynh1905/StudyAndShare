/**
 * @project: observer-pattern
 * @author: HuyHuynh on 12/06/2021
 */
class DataCenterWeather : SubjectWeather {
    var tempure: Float = 0F
    var humidity: Float = 0F
    var pressure: Float = 0F
    var observers: MutableList<ObserverWeather> ?= null

    init {
        this.observers = mutableListOf()
    }


    override fun registerObserver(observerWeather: ObserverWeather) {
        observers?.add(observerWeather)
    }

    override fun remove(observerWeather: ObserverWeather) {
        if (observers?.contains(observerWeather)==true){
            observers?.remove(observerWeather)
        }
    }

    fun updateData(){
        observers?.let {
            for(i in 0 until it.size){
                it[i].update(tempure, humidity, pressure)
            }
        }

    }

    override fun noityfyData() {
        updateData()
    }

    fun measureDataChange(tempure: Float, humidity: Float, pressure: Float){
        this.tempure = tempure
        this.humidity = humidity
        this.pressure = pressure
        noityfyData()
    }
}