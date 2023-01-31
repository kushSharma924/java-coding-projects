public class Cat extends Animal {
    private int numLives;
    public Cat(String name, int birthYear, int numLives) {
        super(name, birthYear);
        this.numLives = numLives;
    }
    public Cat(String name, int birthYear) {
        this(name, birthYear, 9);
    }
    public String toString() {
        return super.toString() + "I have " + numLives + " lives. \n";
    }
}
