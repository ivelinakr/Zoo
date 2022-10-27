/* Singleton Design Pattern */
import Animals.*;
import java.util.ArrayList;
import java.util.HashMap;

public class AnimalFactory {
    private HashMap<String,ArrayList<Animal>> animals = new HashMap<>();

    private void addAnimal (String animalType, Animal animal) {
        animals.putIfAbsent(animalType, new ArrayList<>());
        animals.get(animalType).add(animal);
    }

    private static AnimalFactory instance = new AnimalFactory();

    private AnimalFactory() {
    }

    public static AnimalFactory getInstance() {
        return instance;
    }

    public Animal createAnimal(String animalType) {
        if (animalType == null || animalType.isEmpty()) {
            System.out.println("Please enter a valid animal type.");
            throw new IllegalArgumentException("Input is empty");
        }

        switch (animalType) {
            case "cat":
                Cat cat = new Cat();
                addAnimal(animalType, cat);
                return cat;
            case "cow":
                Cow cow = new Cow();
                addAnimal(animalType, cow);
                return cow;
            case "dog":
                Dog dog = new Dog();
                addAnimal(animalType, dog);
                return dog;
            case "horse":
                Horse horse = new Horse();
                addAnimal(animalType, horse);
                return horse;
            case "bird":
                Bird bird = new Bird();
                addAnimal(animalType, bird);
                return bird;
            default:
                throw new IllegalArgumentException("Invalid animal type: " + animalType);
        }
    }

    public ArrayList<Animal> getAnimals(String type) {
        return animals.get(type);
    }

    public ArrayList<Animal> getAllAnimals() {
        ArrayList<Animal> allAnimals = new ArrayList<>();

        for (ArrayList<Animal> entry : animals.values()) {
            allAnimals.addAll(entry);
        }

        return allAnimals;
    }
}
