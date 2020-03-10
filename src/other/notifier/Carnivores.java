package other.notifier;

import java.util.Observable;

public class Carnivores extends Animals {

    public Carnivores()
    {
        this.state = State.calm;
    }

    @Override
    public void eat() {
        this.state = State.calm;
        System.out.println("Eat meat");
    }

    @Override
    public void noise() {
        this.state = State.noise;
        System.out.println("Carnivores noise");
    }

    @Override
    public void update(Observable observable, Object o) {
        switch ((Notifier.Events)o)
        {
            case feed_carnivores:
            {
                if (this.state != State.noise) {
                    this.noise();
                    this.setChanged();
                    this.notifyObservers(Notifier.Events.noise);
                }
                break;
            }
            case noise:
            {
                if (this.state != State.noise) this.noise();
                break;
            }
        }
    }
}
