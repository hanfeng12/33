package invaders.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverSubject {
    private List<Observer> list = new ArrayList<Observer>();
    public void attach(Observer observer){
        list.add(observer);
    }
    public void detach(Observer observer){
        list.remove(observer);
    }
    public void nodifyObservers(){

        for(Observer observer : list){
            observer.updateObserver();
        }
    }
}
