package zoo.observer;

import java.util.ArrayList;
import java.util.List;

class Animals implements Observer{

    protected enum State {calm, noise, sleep};
    protected State state = State.calm;

    public enum Type {Carnivores, Herbivores};

    @Override
    public void handleEvent() {

    }

    @Override
    public void feed(Type type) {

    }
}
interface Observer{
    void handleEvent();
    void feed(Animals.Type type);
}
interface Observed{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class Watcher implements Observed{

    List<Observer> animals = new ArrayList<>();


    @Override
    public void addObserver(Observer o) {
        animals.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        animals.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o:animals){
            o.handleEvent();
        }
    }

    public void feed(Animals.Type type) {

    }
}
public class Zoo {
    public static void main(String[] args) {

        List<Animals> animals = new ArrayList<>();
        animals.add(new Herbivores());
        animals.add(new Carnivores());
        Watcher watcher = new Watcher();

        for (Animals anim : animals){
            watcher.addObserver(anim);
        }

        watcher.feed(Animals.Type.Carnivores);
        System.out.println("Hello");
    }
}
