/**
 * @project: observer-pattern
 * @author: HuyHuynh on 12/06/2021
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyDataChange();
}
