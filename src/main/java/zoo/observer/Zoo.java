package zoo.observer;

import java.util.ArrayList;
import java.util.List;

//

public class Zoo  {

    public enum Events {
        feed_herbivores,
        feed_carnivores,
        noise,
        thunder,
        night,
        sun,
        sleep
    }
    List<Animals> animals;

    Zoo(){
        animals = new ArrayList<>();
    }
    public void add(Animals animal){
        animals.add(animal);
    }


    public static void main(String[] args) {

      //  Zoo animals = new Zoo();
       // Zoo.add((new Herbivores());
//        List<Animals> animals = new ArrayList<>();
//        animals.add(new Herbivores());
//        animals.add(new Carnivores());
//        animals.add(new Carnivores());
//        animals.add(new Carnivores());
//        animals.add(new Herbivores());
//        Watcher watcher = new Watcher();
//
//       // printAnimals(animals);
//        for (Animals anim : animals){
//            watcher.addObserver(anim);
//            anim.addObserver(watcher);
//        }
//        //animals.get(0).feed();
//        //watcher.notifyObservers(Events.sleep);
//        watcher.feedAll(Animals.Type.Carnivores);
//
//        printAnimals(animals);
    }
}
