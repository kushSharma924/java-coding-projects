public class Toy {
    private String name;
    public Toy(String name) {
        this.name = name;
    }
    public String toString() {
        return "A " + name;
    }
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Toy)) {
            return false;
        }
        Toy t = (Toy) other;
        return (this.name.equals(t.name)) ? true : false;
    }
}
