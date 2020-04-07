package ru.marker;

import java.util.ArrayList;

class Zebra extends Herbivores
{
    private String name = "Zebra";
    @Override
    public String getName() {
        return name;
    }

}
class Lion extends Carnivores
{
    private String name = "Lion";
    @Override
    public String getName() {
        return name;
    }

}
public class Zoo
{

    enum Types {Carnivores, Herbivores};
    enum Weather {Sunny, Thunder};
    enum Time {Morning, Night};

    enum Action{Eat , Sleep, Awake, Noise, FeedCarnivores, FeedHerbivores};

    private ArrayList<Animals> animals;


    Zoo()
    {
        animals = new ArrayList<Animals>();
        animals.add(new Lion());
        animals.add(new Lion());
        animals.add(new Zebra());
        animals.add(new Lion());


    }
    public void weather(Weather weather)
    {
        switch (weather)
        {
            case Sunny:
                //doAction(Action.Awake);
                break;
            case Thunder:
                doAction(Action.Noise);
                break;
        }
    }

    public void time(Time time)
    {
        switch (time)
        {
            case Morning:
                doAction(Action.Awake);
                break;
            case Night:
                doAction(Action.Sleep);
                break;
        }
    }
    private void doAction(Action action)
    {
        for (Animals animal:animals)
        {
            switch (action)
            {
                case Eat:
                    animal.eat();
                    break;
                case Sleep:
                    int count = animals.size();
                    int my_count = 0;
                    for (Animals thisAnimal:animals)
                    {
                        if (thisAnimal.isNoise())
                            break;
                        my_count++;
                    }
                    if (count == my_count)
                        animal.sleep();
                    break;
                case Awake:
                    animal.awake();
                    break;
                case Noise:
                case FeedHerbivores:
                    animal.noise();
                    break;
                case FeedCarnivores:

                    if (animal.getType().equals(Types.Herbivores))
                        continue;
                    animal.noise();
                    break;
            }
        }
    }

    void print()
    {
        for (Animals animal:animals)
        {
            System.out.println(animal.getName());
            animal.printName();
        }
        System.out.println("===========");
    }
    public void start()
    {
        print();
       // doAction(Action.Noise);
       // doAction(Action.Sleep);
        doAction(Action.FeedCarnivores);
//        doAction(Action.Noise);
        doAction(Action.Eat);
        doAction(Action.FeedCarnivores);
        //doAction(Action.Sleep);
        time(Time.Night);
        doAction(Action.Eat);
//        time(Time.Morning);
//        doAction(Action.FeedCarnivores);
//        doAction(Action.Eat);
        time(Time.Night);
        //weather(Weather.Thunder);


        print();



    }


}
