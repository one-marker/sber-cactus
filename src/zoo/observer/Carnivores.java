package zoo.observer;

class Carnivores extends Animals {
    @Override
    public void feed() {

        state = State.noise;

        notifyObservers();
        //notifyObservers(this.getClass().getName().toString());
    }


    @Override
    public void feed(Type type) {

        state = State.noise;

        notifyObservers();
        //notifyObservers(this.getClass().getName().toString());
    }

    public void feedAll(Animals.Type type) {

        if (type == Type.Herbivores){
            state = State.noise;
        }

    }

//    @Override
//    public void handleEvent() {
//        state = State.noise;
//        System.out.println("handleEvent2");
//    }

}
