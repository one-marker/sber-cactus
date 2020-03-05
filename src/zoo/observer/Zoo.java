package zoo.observer;

import java.util.ArrayList;
import java.util.List;


interface Observer{
    void handleEvent();
    void handleEvent(Zoo.Events events);
    void feed(Animals.Type type);
}

interface Observed{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
    void notifyObservers(Zoo.Events events);

}



class Animals extends Watcher {



    protected enum State {calm, noise, sleep};
    protected State state = State.calm;

    public enum Type {Carnivores, Herbivores};


    @Override
    public void handleEvent() {
//
//        if (state!=State.noise)
//            state = State.sleep;
//        else
//        {
//            feedAll(Type.Herbivores);
//           // notifyObservers(Zoo.Events.noise);
//        }

      //
    }

    @Override
    public void feed(Type type) {

    }

    public void feed() { }
}


class Watcher implements Observer, Observed {

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
            System.out.println("watcher");
            o.handleEvent();
        }
    }

    @Override
    public void handleEvent() {
        notifyObservers();
        System.out.println("handleEvent -+");
    }
    @Override
    public void handleEvent(Zoo.Events events) {
        switch (events){
            case sleep:
                notifyObservers();
                System.out.println("handleEvent -+");
                break;

        }

    }

    @Override
    public void notifyObservers(Zoo.Events events) {

        switch (events){
            case sleep:
                System.out.println("sleepAction");
                for (Observer o:animals){

                    o.handleEvent();
                }
                break;
            case noise:
                System.out.println("noiseAction");
                for (Observer o:animals){

                    o.handleEvent();
                }

                break;

        }

    }
    @Override
    public void feed(Animals.Type type) {
        for (Observer o:animals){
            o.feed(type);
        }
    }

    public void feedAll(Animals.Type type) {
        for (Observer o:animals){
            o.feed(type);
        }
    }
}


public class Zoo {
    public enum Events
    {
        feed_herbivores,
        feed_carnivores,
        noise,
        thunder,
        night,
        sun,
        sleep
    }

    public static void printAnimals(List<Animals> animals){
        System.out.println("\n===============\n");
        for (Animals anim : animals){
            System.out.println(anim.getClass().getName());
            System.out.println(anim.state+"\n---------");
        }
        System.out.println("\n===============\n");



    }
    public static void main(String[] args) {

        List<Animals> animals = new ArrayList<>();
        animals.add(new Herbivores());
        animals.add(new Carnivores());
        animals.add(new Carnivores());
        animals.add(new Carnivores());
        animals.add(new Herbivores());
        Watcher watcher = new Watcher();

       // printAnimals(animals);
        for (Animals anim : animals){
            watcher.addObserver(anim);
            anim.addObserver(watcher);
        }
        //animals.get(0).feed();
        //watcher.notifyObservers(Events.sleep);
        watcher.feedAll(Animals.Type.Carnivores);

        printAnimals(animals);
    }
}
