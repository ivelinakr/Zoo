import Animals.Animal;
import com.sun.xml.internal.ws.util.StringUtils;
import java.util.*;

public class Demo {
    public static String getInputFromUser(Set<String> setOfAnimals) {
        // provides instructions for the user
        System.out.println("\nEnter animal type to interact with all generated animals of that type");
        System.out.println("You can choose multiple types by separating them with \",\"");
        System.out.print("Available types in this instance: ");
        System.out.print(setOfAnimals);
        System.out.println("\nIf no animal type is chosen, you will interact with all generated animals");

        // gets input
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        // normalises input
        input = input.toLowerCase();

        // removes all whitespaces and non-visible characters (e.g., tab, \n).
        input = input.replaceAll("\\s+","");

        System.out.println("You entered: " + input);
        return input;
    }

    public static LinkedHashSet<String> getEntries(String s) {
        // separates entries by ","
        String[] arr = s.split(",");

        // adds them to LinkedHashSet to retain the order and remove duplicates
        LinkedHashSet<String> set = new LinkedHashSet<>();

        Collections.addAll(set, arr);

        return set;
    }

    public static void interactWithEach(ArrayList<Animal> animals) {
        for (Animal animal : animals) {
            animal.makeSound();
            animal.move();
        }
    }

    public static void interact(String input, AnimalFactory animalFactory, Set<String> setOfAnimals) {
        if (input.equals("")) {
            // interact with all animals when input is null
            interactWithEach(animalFactory.getAllAnimals());
        } else {
            // checks selected animal types in input and interacts only with them
            LinkedHashSet<String> entries = getEntries(input);

            for (String entry : entries) {
                if (!(setOfAnimals.contains(entry))) {
                    System.out.println(entry + " does not exist in current instance");
                } else {
                    interactWithEach(animalFactory.getAnimals(entry));
                }
            }
        }
    }

    public static void initializeAnimal(String type, AnimalFactory animalFactory, Set<String> setOfAnimals) {
        // creates the animal, names the animal and adds it to the unique types of the instance
        Animal animal = animalFactory.createAnimal(type);
        String animalName = StringUtils.capitalize(type) + "_" + (animalFactory.getAnimals(type).size());
        animal.setName(animalName);
        animal.makeSound();
        setOfAnimals.add(type);
    }

    public static void main(String[] args) {
        // gets singleton Factory instance
        AnimalFactory animalFactory = AnimalFactory.getInstance();

        // min max values of animals to be generated
        int minAnimals = 10;
        int maxAnimals = 20;

        // gets random number of animals between the min and max values
        int totalAnimals = minAnimals + (int) (Math.random() * (maxAnimals - minAnimals));
        System.out.println("Random number of animals to be generated: " + totalAnimals);

        // stores all unique types of animals generated in the current instance
        Set<String> setOfAnimals = new HashSet<>();

        for (int i = 0; i<totalAnimals; i++) {
            // picks an animal type randomly
            // names the animal in the format "Type_n"
            // the animal makes a sound upon creation
            int randomNumberForType = (int) (Math.random() * 5 + 1);

            switch (randomNumberForType){
                case 1:
                    initializeAnimal("cat", animalFactory, setOfAnimals);
                    break;
                case 2:
                    initializeAnimal("dog", animalFactory, setOfAnimals);
                    break;
                case 3:
                    initializeAnimal("bird", animalFactory, setOfAnimals);
                    break;
                case 4:
                    initializeAnimal("horse", animalFactory, setOfAnimals);
                    break;
                case 5:
                    initializeAnimal("cow", animalFactory, setOfAnimals);
                    break;
            }
        }

        String input = getInputFromUser(setOfAnimals);

        interact(input, animalFactory, setOfAnimals);
    }
}
