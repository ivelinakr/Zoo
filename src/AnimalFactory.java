/* Singleton Design Pattern */
import Animals.*;
import java.util.ArrayList;

public class AnimalFactory {
    private ArrayList<Animal> allCats = new ArrayList<>();
    private ArrayList<Animal> allCows = new ArrayList<>();
    private ArrayList<Animal> allDogs = new ArrayList<>();
    private ArrayList<Animal> allHorses = new ArrayList<>();
    private ArrayList<Animal> allBirds = new ArrayList<>();

    private static AnimalFactory instance = new AnimalFactory();

    private AnimalFactory() {
    }

    public static AnimalFactory getInstance() {
        return instance;
    }

    public Animal createAnimal(String animalType) {
        if (animalType == null || animalType.isEmpty()) {
            System.out.println("Please enter a valid animal type.");
            return null;
        }
        switch (animalType) {
            case "cat":
                Cat cat = new Cat();
                allCats.add(cat);
                return cat;
            case "cow":
                Cow cow = new Cow();
                allCows.add(cow);
                return cow;
            case "dog":
                Dog dog = new Dog();
                allDogs.add(dog);
                return dog;
            case "horse":
                Horse horse = new Horse();
                allHorses.add(horse);
                return horse;
            case "bird":
                Bird bird = new Bird();
                allBirds.add(bird);
                return bird;
            default:
                throw new IllegalArgumentException("Unknown channel " + animalType);
        }
    }

    public ArrayList<Animal> getAnimals(String type) {
        switch (type) {
            case "cats":
                return allCats;
            case "cows":
                return allCows;
            case "dogs":
                return allDogs;
            case "horses":
                return allHorses;
            case "birds":
                return allBirds;
            default:
                throw new IllegalArgumentException("Unknown channel " + type);
        }
    }

    public ArrayList<Animal> getAllAnimals() {
        ArrayList<Animal> all = allCats;
        all.addAll(allCows);
        all.addAll(allDogs);
        all.addAll(allHorses);
        all.addAll(allBirds);

        return all;
    }
}
