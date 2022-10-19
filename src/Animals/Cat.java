package Animals;

public class Cat implements Animal {
    private String name = "Cat has no name";
    @Override
    public void makeSound() {
        System.out.println(this.name + ": Meow!");
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
