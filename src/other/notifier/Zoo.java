package other.notifier;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    public enum AnimalType{
        herbivores,
        carnivores;
    };

    private List<Animals> animals;
    private Notifier notifier;

    //public enum FileType{XML, JSON};
    //public Zoo(String path, FileType fileTypes)
    //{
    //    //TODO чтение XML или JSON файла
    //}

    public Zoo(List<Animals> _animals)
    {
        this.animals = new ArrayList<>();
        this.notifier = new Notifier();

        for (Animals a : _animals)
        {
            animals.add(a);
            notifier.addObserver(a);
            a.addObserver(this.notifier);
        }
    }

    public void FeedAnimals(AnimalType type)
    {
        this.notifier.BroadcastFeed(type);
        for (Animals animal: this.animals)
        {
            if (animal.is(type)) animal.eat();
        }
    }

    public void CheckAnimals()
    {
        System.out.println("\nAnimals states");
        for (Animals animal : animals)
        {
            if (animal instanceof Herbivores)System.out.println("Herbivores: "+ animal.state);
            if (animal instanceof Carnivores)System.out.println("Carnivores: "+ animal.state);
        }
        System.out.println();
    }
}
