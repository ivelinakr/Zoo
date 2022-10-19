package Animals;

public class Horse implements Animal {
    private String name = "Horse has no name";

    @Override
    public void makeSound() {
        System.out.println(this.name + ": Neigh!");
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
