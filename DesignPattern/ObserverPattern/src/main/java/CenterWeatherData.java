import java.util.ArrayList;
import java.util.List;

/**
 * @project: observer-pattern
 * @author: HuyHuynh on 12/06/2021
 */
public class CenterWeatherData implements Subject {
    private List<Observer> observers;
    private float tempera;
    private float pressure;
    private float humidity;

    public CenterWeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)){
            observers.remove(observer);
        }
    }

    private void notifyObservers(){
        for (int i=0; i<observers.size();i++){
            observers.get(i).updateDataChange(tempera,pressure,humidity);
        }
    }

    @Override
    public void notifyDataChange() {
        notifyObservers();
    }

    public void measurementChanges(float tempera,float pressure,float humidity){
        this.tempera = tempera;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyDataChange();
    }
}
