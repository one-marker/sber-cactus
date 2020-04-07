package other.notifier;

import java.util.Observable;
import java.util.Observer;

public abstract class Animals extends Observable implements Observer {

    public enum State{sleep, noise, calm};

    protected State state;

    public void eat()
    {
        this.state = State.calm;
        System.out.println("Eat");
    }

    public void sleep()
    {
        this.state = State.sleep;
        System.out.println("Sleep");
    }

    public void noise()
    {
        this.state = State.noise;
        System.out.println("Noise");
    }

    public boolean is(Zoo.AnimalType type)
    {
        if (this instanceof Herbivores && type == Zoo.AnimalType.herbivores ||
            this instanceof Carnivores && type == Zoo.AnimalType.carnivores)return true;
        return false;
    }
}
