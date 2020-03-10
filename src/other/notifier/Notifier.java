package other.notifier;

import java.util.Observable;
import java.util.Observer;

public class Notifier extends Observable implements Observer{

    public enum Events
    {
        feed_herbivores,
        feed_carnivores,
        noise,
        thunder,
        night,
        sun;

        public static Events interpret(Zoo.AnimalType type)
        {
            if (Zoo.AnimalType.herbivores == type) {return feed_herbivores;}
            else return feed_carnivores;
        }
    };

    public Notifier() {}

    public void BroadcastFeed(Zoo.AnimalType type)
    {
        this.setChanged();
        this.notifyObservers(Events.interpret(type));
    }

    @Override
    public void update(Observable observable, Object o) {
        this.setChanged();
        this.notifyObservers(o);
    }
}
