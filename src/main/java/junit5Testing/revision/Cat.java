package junit5Testing.revision;

public class Cat extends Animal implements Movable{

    public Cat(String name) {
        super(name);
    }

    @Override
    void move() {
        System.out.println("hh");
    }

    @Override
    public void moveFast() {

    }
}
