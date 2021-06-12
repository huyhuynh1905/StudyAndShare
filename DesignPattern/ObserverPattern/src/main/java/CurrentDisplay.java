/**
 * @project: observer-pattern
 * @author: HuyHuynh on 12/06/2021
 */
public class CurrentDisplay implements Observer,DisplayElement {
    private float tempera;
    private float pressure;
    private Subject subject;

    public CurrentDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current Display: Temp = "+this.tempera+" - Pressure = "+this.pressure);
    }

    @Override
    public void updateDataChange(float tempera, float pressure, float humidity) {
        this.tempera = tempera;
        this.pressure = pressure;
        display();
    }
}
