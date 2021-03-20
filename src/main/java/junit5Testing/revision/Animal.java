package junit5Testing.revision;

public abstract class Animal {

    public Animal(String name){
        this.name = name;
    }

    private String name;
    private int sum;

    abstract void move();
}
