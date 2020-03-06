package zoo.observer;

class Herbivores extends Animals {
    @Override
    public void feed() {


        if (Herbivores.class.getName().equals(this.getClass().getName())){
            state = State.noise;
        }
        state = State.noise;
        notifyObservers();
     //  handleEvent();



    }

    public void feedAll(Animals.Type type) {

        if (type == Type.Herbivores){
            state = State.noise;
        }

    }

//    @Override
//    public void handleEvent() {
//        System.out.println("handleEvent0");
//    }

}