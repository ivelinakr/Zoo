package Animals;

public class Bird implements Animal {
    private String name = "Bird has no name";

    @Override
    public void makeSound() {
        System.out.println(this.name + ": Tweet!");
    }

    @Override
    public void move() {
        System.out.println(this.name + " flew.");
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
