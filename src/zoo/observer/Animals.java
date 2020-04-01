package zoo.observer;

public class Animals implements Observer {
    public enum States{
        CALM,
        SLEEP,
        NOISE
    };
    States animalState;
    Animals() {

    }

    @Override
    public void updateState(Events event) {

    }
}
