package Animals;

public class Cow implements Animal {
    private String name = "Cow has no name";

    @Override
    public void makeSound() {
        System.out.println(this.name + ": Moo!");
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
