package other.notifier;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Herbivores zebra = new Herbivores();
        Herbivores elephant = new Herbivores();
        Carnivores lion = new Carnivores();
        Carnivores tiger = new Carnivores();

        Zoo zoo = new Zoo(Arrays.asList(zebra, elephant, lion, tiger));

        zoo.FeedAnimals(Zoo.AnimalType.carnivores);
        zoo.CheckAnimals();
        zoo.FeedAnimals(Zoo.AnimalType.herbivores);
        zoo.CheckAnimals();
    }
}
