/**
 * @project: observer-pattern
 * @author: HuyHuynh on 12/06/2021
 */
public class FutureDisplay implements Observer,DisplayElement {
    private float humidity;
    private float pressure;
    private Subject subject;

    public FutureDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Future Display: Humidity = "+this.humidity+" - Pressure = "+this.pressure);
    }

    @Override
    public void updateDataChange(float tempera, float pressure, float humidity) {
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }
}
