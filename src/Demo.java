import Animals.Animal;

import java.util.*;

public class Demo {
    public static LinkedHashSet<String> getEntries(String s) {
        // separates entries by ","
        String[] arr = s.split(",");

        // adds them to LinkedHashSet to retain the order and remove duplicates
        LinkedHashSet<String> set = new LinkedHashSet<String>();

        for(int i=0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        return set;
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

        int catCount = 0;
        int dogCount = 0;
        int birdCount = 0;
        int horseCount = 0;
        int cowCount = 0;

        // stores all unique types of animals generated in the current instance
        Set<String> setOfAnimals = new HashSet<String>();

        for (int i = 0; i<totalAnimals; i++) {
            // picks an animal type randomly
            // names the animal in the format "Type_n"
            // the animal makes a sound upon creation
            int randomNumberForType = (int) (Math.random() * 5 + 1);

            switch (randomNumberForType){
                case 1:
                    String catName = "Cat_" + (++catCount);
                    Animal cat = animalFactory.createAnimal("cat");
                    cat.setName(catName);
                    cat.makeSound();
                    setOfAnimals.add("cat");
                    break;
                case 2:
                    String dogName = "Dog_" + (++dogCount);
                    Animal dog = animalFactory.createAnimal("dog");
                    dog.setName(dogName);
                    dog.makeSound();
                    setOfAnimals.add("dog");
                    break;
                case 3:
                    String birdName = "Bird_" + (++birdCount);
                    Animal bird = animalFactory.createAnimal("bird");
                    bird.setName(birdName);
                    bird.makeSound();
                    setOfAnimals.add("bird");
                    break;
                case 4:
                    String horseName = "Horse_" + (++horseCount);
                    Animal horse = animalFactory.createAnimal("horse");
                    horse.setName(horseName);
                    horse.makeSound();
                    setOfAnimals.add("horse");
                    break;
                case 5:
                    String cowName = "Cow_" + (++cowCount);
                    Animal cow = animalFactory.createAnimal("cow");
                    cow.setName(cowName);
                    cow.makeSound();
                    setOfAnimals.add("cow");
                    break;
            }
        }

        System.out.println("\nEnter animal type to interact with all generated animals of that type");
        System.out.println("You can choose multiple types by separating them with \",\"");
        System.out.print("Available types in this instance: ");
        System.out.print(setOfAnimals);
        System.out.println("\nIf no animal type is chosen, you will interact with all generated animals");

        // get input
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        // normalise input
        input = input.toLowerCase();

        // removes all whitespaces and non-visible characters (e.g., tab, \n).
        input = input.replaceAll("\\s+","");

        System.out.println("You entered: " + input);

        if (input == null || input.equals("")) {
            // interact with all animals when input is null
            ArrayList<Animal> allAnimals = animalFactory.getAllAnimals();

            for (int i = 0; i<allAnimals.size(); i++) {
                allAnimals.get(i).makeSound();
                allAnimals.get(i).move();
            }
        } else {
            // checks selected animal types in input and interacts only with them
            LinkedHashSet<String> entries = getEntries(input);

            System.out.println("SET " + setOfAnimals);

            for (String entry : entries) {
                if (!(setOfAnimals.contains(entry))) {
                    System.out.println(entry + " does not exist in current instance");
                } else if (Objects.equals(entry, "cat")) {
                    ArrayList<Animal> cats = animalFactory.getAnimals("cats");
                    for (Animal cat : cats) {
                        cat.makeSound();
                        cat.move();
                    }
                } else if (Objects.equals(entry, "dog")) {
                    ArrayList<Animal> dogs = animalFactory.getAnimals("dogs");
                    for (Animal dog : dogs) {
                        dog.makeSound();
                        dog.move();
                    }
                } else if (Objects.equals(entry, "cow")) {
                    ArrayList<Animal> cows = animalFactory.getAnimals("cows");
                    for (Animal cow : cows) {
                        cow.makeSound();
                        cow.move();
                    }
                } else if (Objects.equals(entry, "horse")) {
                    ArrayList<Animal> horses = animalFactory.getAnimals("horses");
                    for (Animal horse : horses) {
                        horse.makeSound();
                        horse.move();
                    }
                } else if (Objects.equals(entry, "bird")) {
                    ArrayList<Animal> birds = animalFactory.getAnimals("birds");
                    for (Animal bird : birds) {
                        bird.makeSound();
                        bird.move();
                    }
                }
            }
        }
    }
}