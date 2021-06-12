/**
 * @project: observer-pattern
 * @author: HuyHuynh on 12/06/2021
 */
public class MainObserver {
    public static void main(String[] args) {
        CenterWeatherData centerWeatherData = new CenterWeatherData();
        CurrentDisplay currentDisplay = new CurrentDisplay(centerWeatherData);
        FutureDisplay futureDisplay = new FutureDisplay(centerWeatherData);

        centerWeatherData.measurementChanges(1,2,3);
        centerWeatherData.measurementChanges(3,4,5);
        centerWeatherData.measurementChanges(3,2,1);
        centerWeatherData.measurementChanges(5,6,7);
    }
}
