package other.notifier;

import java.util.Observable;

public class Herbivores extends Animals {

    public Herbivores()
    {
        this.state = State.calm;
    }

    @Override
    public void eat() {
        this.state = State.calm;
        System.out.println("Eat plants");
    }

    @Override
    public void noise() {
        this.state = State.noise;
        System.out.println("Herbivores noise");
    }

    @Override
    public void update(Observable observable, Object o) {
        switch ((Notifier.Events)o)
        {
            case feed_herbivores:
            {
                if (this.state != State.noise) this.noise();
                this.setChanged();
                this.notifyObservers(Notifier.Events.noise);
                break;
            }
        }
    }
}
