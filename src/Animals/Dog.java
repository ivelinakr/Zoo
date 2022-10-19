package Animals;

public class Dog implements Animal {
    private String name= "Dog has no name";

    @Override
    public void makeSound() {
        System.out.println(this.name + ": Woof!");
    }

    @Override
    public void move() {
        System.out.println(this.name + " moved.");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String newName) {
        this.name = newName;
    }
}
